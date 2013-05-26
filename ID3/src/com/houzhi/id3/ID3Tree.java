package com.houzhi.id3;

import scut.houzhi.id3.struct.ID3ComponentNode;
import scut.houzhi.id3.struct.ID3Node;

public class ID3Tree {
	private ID3Node root;
	//当前的计算节点
	private ID3Node curNode = null;
	public ID3Tree(ID3Node root){
		this.root = root;
		curNode = root;
	}
	public ID3Tree(){
		this(null);
	}
	public void addChild(ID3Node node){
		if(root==null){
			root=node;
			curNode = node;
		}else
			if(!node.isLeaf()){
				((ID3ComponentNode)curNode).addChild(node);
			}
	}
	
	/**
	 * 根节点
	 * @return
	 */
	public ID3Node getRoot(){
		return root;
	}
	public void addChildTree(ID3Tree tree){
		addChild(tree.getRoot());
//		curNode.addNode(tree.getRoot());
	}
	/**
	 * 打印树
	 */
	public void print() {
		// TODO Auto-generated method stub
		root.print();
	}
}
