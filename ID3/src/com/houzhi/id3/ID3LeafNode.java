package com.houzhi.id3;

import com.houzhi.id3.uitl.AttributeFactory;
import com.houzhi.id3.uitl.Type;
import com.houzhi.id3.uitl.TypeFactory;

public class ID3LeafNode extends ID3Node {
	private Type type;
	public ID3LeafNode(Type type) {
//		super(attribute);
		// TODO Auto-generated constructor stub
	}
	public Type getType(){
		return type;
	}
	@Override
	public void print() {
		System.out.println(type.getId());
	}

}
