package com.houzhi.id3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.houzhi.id3.uitl.Attribute;

public class ID3ComponentNode extends ID3Node {

//	public ID3ComponentNode(Attribute attribute) {
//		super(attribute);
//		// TODO Auto-generated constructor stub
//	}
	private Attribute attribute;
	/**
	 * 这个节点依照attribute 属性来进行分类
	 * @param attribute
	 */
	public ID3ComponentNode(Attribute attribute){
		this.attribute = attribute;
		child = new ArrayList<ID3Node>();
		iter = child.iterator();
	}
	//子节点
	private List<ID3Node> child=null;
	
	public void addNode(ID3Node node){
		child.add(node);
	}
	private Iterator<ID3Node> iter = null;
	public ID3Node next(){
		return iter.next();
	}
}
