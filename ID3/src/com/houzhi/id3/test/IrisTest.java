package com.houzhi.id3.test;

import java.util.ArrayList;
import java.util.List;

import com.houzhi.id3.ID3;
import com.houzhi.id3.ID3ComponentNode;
import com.houzhi.id3.Record;
import com.houzhi.id3.uitl.Attribute;

public class IrisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IrisRead iris = new IrisRead("iris.txt");
		List<Record> list = iris.readRecordList();
		System.out.println(list+"");
		System.out.println(iris.petalLength.idList());
		System.out.println(iris.petalLength.getListAttribute());
		System.out.println(iris.type.getListAttribute());
		
		List<Attribute> attributeList = new ArrayList<Attribute>();
		attributeList.add(iris.sepalLength);
		attributeList.add(iris.sepalWidth);
		attributeList.add(iris.petalLength);
		attributeList.add(iris.petalWidth);
		ID3 id3 = new ID3(attributeList, list, iris.type);
		id3.buildID3();
	} 

}
