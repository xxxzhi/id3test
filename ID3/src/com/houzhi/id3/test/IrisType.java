package com.houzhi.id3.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.houzhi.id3.uitl.Type;

public class IrisType extends Type<String> {

	public IrisType(List<String> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Type<String> copy() {
		// TODO Auto-generated method stub
		return new IrisType(new ArrayList<String>((listAttribute)));
	}

}
