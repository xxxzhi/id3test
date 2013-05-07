package com.id3;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ID3 {
	class AttributePair{
		public AttributePair(Attribute a,int p){
			this.attribute = a;
			this.position = p;
		}
		Attribute attribute;
		int position;
	}
	
	private List<Attribute> attributeList;
	private List<Record> samples;
	private ID3Tree<ID3Node> tree = new ID3Tree<ID3Node>();
	public ID3(List<Attribute> attributeList,List<Record> samples){
		this.attributeList = attributeList;
		this.samples = samples;
	}
	
	/**
	 * 建造id3
	 */
	public void buildID3(){
		tree.addChildTree(buildID3Inner(new ArrayList<Attribute>(attributeList),samples));
	}
	private ID3Tree<ID3Node> buildID3Inner(List<Attribute> copyAttribtes,List<Record> samples){
		
		AttributePair pair = countAttributes(copyAttribtes,samples);
		//构建树
		ID3Node node = new ID3Node(pair.attribute);
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
		for(int i=0;i!=idList.size();++i){
			child.addChildTree(buildID3Inner(copyAttribtes, lsamples.get(i)));
		}
		return child;
	}
	
	public AttributePair countAttributes(List<Attribute> attributes,List<Record> samples){
		double entropy;
		double min = 0;			//计算最小熵
		Attribute selectAttributes = null;
		int position =0;
		int i=0;
		for(Attribute e:attributes){
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
	private double countEntropy(Attribute attributes,List<Record> samples,int attributesPosition){
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
}
