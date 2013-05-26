package com.houzhi.id3.test;

import java.util.List;

import scut.houzhi.id3.util.AbsAttribute;
import scut.houzhi.id3.util.AbsAttributeFactory;

import com.houzhi.id3.uitl.AttributeFactory;

public class IrisPetalLengthFactory extends AbsAttributeFactory<Float> {

	public IrisPetalLengthFactory(List<Float> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbsAttribute factory(int v) {
		// TODO Auto-generated method stub
		return new PetalLenghtAttribute(v);
	}
}
