package com.id3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.AsyncBoxView.ChildLocator;

public class ID3Node {
	
	private Attribute attribute;
	/**
	 * 这个节点依照attribute 属性来进行分类
	 * @param attribute
	 */
	public ID3Node(Attribute attribute){
		this.attribute = attribute;
		child = new ArrayList<ID3Node>();
		iter = child.iterator();
	}
	private List<ID3Node> child=null;
	
	public void addNode(ID3Node node){
		child.add(node);
	}
	private Iterator<ID3Node> iter = null;
	public ID3Node next(){
		return iter.next();
	}
}
