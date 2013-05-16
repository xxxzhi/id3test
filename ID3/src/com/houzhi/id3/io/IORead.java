package com.houzhi.id3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.houzhi.id3.Record;

public abstract class IORead {
	protected File file;
	protected BufferedReader reader;
	public IORead(String name){
		try {
			reader = new BufferedReader(new FileReader(new File(name))) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 读取一条记录
	 * @return
	 */
	public abstract Record readRecord();
	
	
	/**
	 * 读取所有的记录
	 * @return
	 */
	public abstract List<Record> readRecordList();
}
