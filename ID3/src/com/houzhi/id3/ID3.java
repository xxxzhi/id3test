package com.houzhi.id3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.houzhi.id3.uitl.Type;
import com.houzhi.id3.uitl.Attribute;

public class ID3<T,T1> {
	class AttributePair{
		public AttributePair(Attribute<T> a,int p){
			this.attribute = a;
			this.position = p;
		}
		Attribute<T> attribute;
		int position;
	}
	private Type<T1> type;
	private List<Attribute<T>> attributeList;
	private List<Record> samples;
	private ID3Tree<ID3Node> tree = new ID3Tree<ID3Node>();
	public ID3(List<Attribute<T>> attributeList,List<Record> samples,Type<T1> type){
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
		tree.addChildTree(buildID3Inner(new ArrayList<Attribute<T>>(attributeList),samples));
	}
	private ID3Tree<ID3Node> buildID3Inner(List<Attribute<T>> copyAttribtes,List<Record> samples){
		
		AttributePair pair = countAttributes(copyAttribtes,samples);
		//构建树
		ID3Node node = new ID3ComponentNode(pair.attribute);
		ID3Tree<ID3Node> child = new ID3Tree<ID3Node>(node);
		
		//分割samples
		List<List<Record>> lsamples = new ArrayList<List<Record>>();
		List<Integer> idList = pair.attribute.idList();
		for(int i = 0;i!=idList.size();++i){
			lsamples.add(new LinkedList<Record>());
		}
		for(Record record:samples){
			int attId = record.get(pair.position);
			lsamples.get(pair.attribute.idPosition(attId)).add(record);
		}
		//删除属性,递归构造
		copyAttribtes.remove(pair.attribute);
		int index = copyAttribtes.indexOf(pair.attribute);
		for(int i=0;i!=idList.size();++i){
			int cur = isSameType(lsamples.get(i));
			if(cur!=-1){
				//同一个类型
				child.addChild(new ID3LeafNode(type.copy().setCur(cur)));
				continue;
			}
			
			if(lsamples.get(i).size()>0){			
				//该分类后，仍有记录
				child.addChildTree(buildID3Inner(copyAttribtes, lsamples.get(i)));
			}else{
				//该分类后没有记录,
				child.addChild(new ID3LeafNode(type.copy().initAll()));
			}
		}
		copyAttribtes.add(index, pair.attribute);
		return child;
	}
	
	public AttributePair countAttributes(List<Attribute<T>> attributes,List<Record> samples){
		double entropy;
		double min = 0;			//计算最小熵
		Attribute<T> selectAttributes = null;
		int position =0;
		int i=0;
		for(Attribute<T> e:attributes){
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
	private double countEntropy(Attribute<T> attributes,List<Record> samples,int attributesPosition){
		List<Integer> listId = attributes.idList();  //属性值
		List<Integer> nums = new ArrayList<Integer>();		//总共属性值的个数
		for(int i=0;i!=listId.size();++i){				//初始化
			nums.add(new Integer(0));
		}
		int sum = samples.size();
		for(Record record:samples){
			int position = attributes.idPosition(record.get(attributesPosition));
			nums.set(position, nums.get(position)+1);
		}
		double entropy = 0;
		//计算熵
		for(int i=0;i!=listId.size();++i){
			double temp = nums.get(i)/sum;
			entropy+=(-temp*Math.log(temp));
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
}
