package com.houzhi.id3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import scut.houzhi.id3.struct.ID3ComponentNode;
import scut.houzhi.id3.struct.ID3LeafNode;
import scut.houzhi.id3.struct.ID3Node;
import scut.houzhi.id3.util.AbsAttributeFactory;
import scut.houzhi.id3.util.Type;


public class ID3<T,T1> {
	class AttributePair{
		public AttributePair(AbsAttributeFactory<T> a,int p){
			this.attribute = a;
			this.position = p;
		}
		AbsAttributeFactory<T> attribute;
		int position;
	}
	private TypeFactory<T1> type;
	private List<AttributeFactory<T>> attributeList;
	private List<Record> samples;
	private ID3Tree tree = new ID3Tree();
	public ID3(List<Record> samples,TypeFactory<T1> type){
		this.type = type;
		if(samples.size()<=0){
			throw new IllegalArgumentException("samples.size()<0");
		}
		if(samples.get(0).getRecord().size()!=attributeList.size()+1){
			throw new IllegalArgumentException("the length of samples:"+samples.get(0).getRecord().size()+
					" is not equal the length of attributeList:"+attributeList.size()+" +1");
		}
		this.attributeList = attributeList;
		this.samples = samples;
	}
	
	/**
	 * 建造id3
	 */
	public void buildID3(){
		tree.addChildTree(buildID3Inner(new ArrayList<AttributeFactory<T>>(attributeList),samples));
	}
	
	private ID3Tree buildID3Inner(List<AttributeFactory<T>> copyAttribtes,List<Record> samples){
		
		AttributePair pair = countAttributes(copyAttribtes,samples);
		//构建树
		ID3Node node = new ID3ComponentNode(pair.position);
		ID3Tree child = new ID3Tree(node);
		
		//分割samples
		List<List<Record>> lsamples = new ArrayList<List<Record>>();
		List<Integer> idList = pair.attribute.idList();
		for(int i = 0;i!=idList.size();++i){
			lsamples.add(new LinkedList<Record>());
		}
		for(Record record:samples){
			int attId = record.get(pair.position).getValue();
			lsamples.get(pair.attribute.idPosition(attId)).add(record);
		}
		//删除属性,递归构造
		copyAttribtes.remove(pair.attribute);
		int index = copyAttribtes.indexOf(pair.attribute);
		for(int i=0;i!=idList.size();++i){
			int cur = isSameType(lsamples.get(i));
			if(cur!=-1){
				//同一个类型
				child.addChild(new ID3LeafNode(new scut.houzhi.id3.util.Type(cur)));
				continue;
			}
			
			if(lsamples.get(i).size()>0){			
				//该分类后，仍有记录
				child.addChildTree(buildID3Inner(copyAttribtes, lsamples.get(i)));
			}else{
				//该分类后没有记录,
				child.addChild(new ID3LeafNode(new Type(cur).initAll()));
			}
		}
		copyAttribtes.add(index, pair.attribute);
		return child;
	}
	
	public AttributePair countAttributes(List<AttributeFactory<T>> attributes,List<Record> samples){
		double entropy;
		double min = 1000000000;			//计算最小熵
		AttributeFactory<T> selectAttributes = null;
		int position =0;
		int i=0;
		for(AttributeFactory<T> e:attributes){
			//计算熵值 并且比较获得最小熵的属性
			entropy = countEntropy(e,samples,i);
			if(min>=entropy){
				min = entropy;
				selectAttributes = e;
				position = i;
			}
			i++;
		}
		return new AttributePair(selectAttributes, position);
	}
	
	/**
	 * 计算熵
	 * @param attributes
	 * @return
	 */
	private double countEntropy(AttributeFactory<T> attributes,List<Record> samples,int attributesPosition){
		List<Integer> listId = attributes.idList();  //属性值
		List<Integer> nums = new ArrayList<Integer>();		//总共属性值的个数
		List<List<Integer>> type = new ArrayList<List<Integer>>();
		for(int i=0;i!=listId.size();++i){				//初始化，区分出属性。
			nums.add(new Integer(0));
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int j=0;j!=this.type.idList().size();++j){
				arr.add(0);
			}
			type.add(arr);
		}
		
		int sum = samples.size();
		for(Record record:samples){
			int position = attributes.idPosition(
					record.get(attributesPosition));		//属性值
			nums.set(position, nums.get(position)+1);
			int typePosition = this.type.idPosition(record.getType());
			type.get(position).set(typePosition, 
					type.get(position).get(typePosition)+1);
		}
		double entropy = 0;
		//计算熵
		for(int i=0;i!=listId.size();++i){
			
			double temp = nums.get(i)/(double)sum;       //Esij/sum
			if(temp==0){
				continue;
			}
			double I=0;
			for(int j=0;j!=this.type.idList().size();++j){
				double entropyItemp = 
				type.get(i).get(j)/(double)nums.get(i);
				if(entropyItemp==0){
					continue;
				}
				I+=(-entropyItemp*Math.log(entropyItemp)/Math.log(2));
			}
			entropy+=temp*I;
		}
		return entropy;
	}
	
	
	private int isSameType(List<Record> samples){
		if(samples.size()==0){
			return -1;
		}
		Record last = samples.get(0);
		int lastIndex = last.size()-1;
		for(int i=1;i!=samples.size();++i){
			Record record = samples.get(i);
			if(!record.get(lastIndex).equals(last.get(lastIndex))){
				return -1;
			}else{
				last= record;
			}
		}
		return last.get(lastIndex);
	}
	
	
	public void printID3Tree(){
		tree.print();
	}
}
