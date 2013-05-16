/**
 * @author houzhi
 * 一条记录
 */
package com.houzhi.id3;

import java.util.List;

public class Record {
	private List<Integer> record;
	
	/**
	 * 记录
	 * @param record 一列属性，用integer 代替的属性。最后一条记录为类型代号
	 */
	public Record(List<Integer> record){
		this.setRecord(record);
	}
	
	public int size(){
		return record.size();
	}
	
	public List<Integer> getRecord() {
		return record;
	}
	public void setRecord(List<Integer> record) {
		this.record = record;
	}
	/**
	 * 获取第position 个属性的值
	 * @param position
	 * @return
	 */
	public Integer get(int position){
		return record.get(position);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return record+"";
	}
	
	
}
