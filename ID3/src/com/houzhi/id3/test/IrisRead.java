package com.houzhi.id3.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.houzhi.id3.Record;
import com.houzhi.id3.io.IORead;

public class IrisRead extends IORead {
	IrisPetalLength petalLength ;
	IrisPetalWidth petalWidth;
	IrisSepalLength sepalLength;
	IrisSepalWidth sepalWidth;
	IrisType type;
	public IrisRead(String name) {
		super(name);
		List<Float> t = new ArrayList<Float>();
		
		DecimalFormat format = new DecimalFormat("#0.0");
		float i = 1.0f;
		while(i<=6.9){
			t.add(Float.valueOf(format.format(i)));
			i=i+0.1f;
		}
		petalLength = new IrisPetalLength(t);
		t = new ArrayList<Float>();
		i = 0.1f;
		while(i<=2.5){
			t.add(Float.valueOf(format.format(i)));
			i=i+0.1f;
		}
		petalWidth = new IrisPetalWidth(t);
		
		t = new ArrayList<Float>();
		i = 4.3f;
		while(i<=7.9){
			t.add(Float.valueOf(format.format(i)));
			i=i+0.1f;
		}
		sepalLength = new IrisSepalLength(t);
		
		t = new ArrayList<Float>();
		i = 2.0f;
		while(i<=4.4){
			t.add(Float.valueOf(format.format(i)));
			i=i+0.1f;
		}
		sepalWidth = new IrisSepalWidth(t);
		
		List<String> list = new ArrayList<String>();
		list.add("Iris-setosa");
		list.add("Iris-versicolor");
		list.add("Iris-virginica");
		type = new IrisType(list);
	}

	@Override
	public Record readRecord() {
		// TODO Auto-generated method stub
		Record record = null;
		try {
			String line = reader.readLine();
			if(line==null){
				return null;
			}
			String values[] = line.split(",");
			List<Integer> list = new ArrayList<Integer>();
			list.add(sepalLength.id(Float.valueOf(values[0])));
			list.add(sepalWidth.id(Float.valueOf(values[1])));
			list.add(petalLength.id(Float.valueOf(values[2])));
			list.add(petalWidth.id(Float.valueOf(values[3])));
			
			list.add(type.id(values[4]));
			
			record = new Record(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public List<Record> readRecordList() {
		// TODO Auto-generated method stub
		Record record = null;
		List<Record> list = new ArrayList<Record>();
		while(true){
			record = readRecord();
			if(record!=null){
				list.add(record);
			}else{
				break;
			}
		}
		return list;
	}

	
}
