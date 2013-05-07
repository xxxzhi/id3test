package com.id3;

public class ID3Tree {
	private ID3Node root;
	//当前的计算节点
	private ID3Node curNode = null;
	public ID3Tree(ID3Node root){
		this.root = root;
		curNode = root;
	}
	
	public void addChild(ID3Node node){
		curNode.addNode(node);
	}
	
}
