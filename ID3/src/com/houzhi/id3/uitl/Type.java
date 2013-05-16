package com.houzhi.id3.uitl;

import java.util.List;

public abstract class Type<T> extends Attribute<T> {
	private int  cur;
	public Type(List<T> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	protected boolean isAll;
	
	public Type<T> setCur(int i){
		this.cur = i;
		return this;
	}
	/**
	 * 标志此处分类为所有，也就是分类树中没有此类
	 * @return
	 */
	public Type<T> initAll(){
		isAll = true;
		return this;
	}

	/**
	 * 返回一个复制的实例，深度复制
	 * @return
	 */
	public abstract Type<T> copy();
	
	
}
