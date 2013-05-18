package com.houzhi.id3.uitl;

public class Type {

	private int id;
	private boolean isAll;
	public Type(int id){
		this.setId(id);
	}
	public int getId() {
		if(isAll){
			return -1;
		}
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 标志此处分类为所有，也就是分类树中没有此类
	 * @return
	 */
	public Type initAll(){
		isAll = true;
		return this;
	}
}
