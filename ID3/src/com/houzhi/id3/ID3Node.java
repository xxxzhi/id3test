package com.houzhi.id3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.AsyncBoxView.ChildLocator;

import com.houzhi.id3.uitl.AttributeFactory;

public abstract class ID3Node {
	
//	private Attribute attribute;
//	/**
//	 * 这个节点依照attribute 属性来进行分类
//	 * @param attribute
//	 */
//	public ID3Node(Attribute attribute){
//		this.attribute = attribute;
//		child = new ArrayList<ID3Node>();
//		iter = child.iterator();
//	}
//	//子节点
//	private List<ID3Node> child=null;
//	
//	public void addNode(ID3Node node){
//		child.add(node);
//	}
//	private Iterator<ID3Node> iter = null;
//	public ID3Node next(){
//		return iter.next();
//	}
	
	public ID3Node(){
		
	}
	/**
	 * 打印节点
	 */
	public abstract void print();
}
