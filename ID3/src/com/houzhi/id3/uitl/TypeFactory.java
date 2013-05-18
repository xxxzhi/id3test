package com.houzhi.id3.uitl;

import java.util.List;

public abstract class TypeFactory<T> extends AttributeFactory<T> {
	private int  cur;
	public TypeFactory(List<T> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	protected boolean isAll;
	
	public TypeFactory<T> setCur(int i){
		this.cur = i;
		return this;
	}
	/**
	 * 标志此处分类为所有，也就是分类树中没有此类
	 * @return
	 */
	public TypeFactory<T> initAll(){
		isAll = true;
		return this;
	}

	/**
	 * 返回一个复制的实例，深度复制
	 * @return
	 */
	public abstract TypeFactory<T> copy();
	
	public T getCurType(){
		return listAttribute.get(cur);
	}
}
