package com.houzhi.id3;

public class ID3Tree<T extends ID3Node> {
	private T root;
	//当前的计算节点
	private T curNode = null;
	public ID3Tree(T root){
		this.root = root;
		curNode = root;
	}
	public ID3Tree(){
		this(null);
	}
	public void addChild(T node){
		if(root==null){
			root=node;
			curNode = node;
		}else
			if(node instanceof ID3ComponentNode){
				((ID3ComponentNode)curNode).addNode(node);
			}
	}
	
	/**
	 * 根节点
	 * @return
	 */
	public T getRoot(){
		return root;
	}
	public void addChildTree(ID3Tree<T> tree){
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
