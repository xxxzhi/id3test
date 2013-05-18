package com.houzhi.id3.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.houzhi.id3.uitl.TypeFactory;

public class IrisType extends TypeFactory<String> {

	public IrisType(List<String> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TypeFactory<String> copy() {
		// TODO Auto-generated method stub
		return new IrisType(new ArrayList<String>((listAttribute)));
	}

}
