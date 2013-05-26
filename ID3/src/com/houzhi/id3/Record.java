/**
 * @author houzhi
 * 一条记录
 */
package com.houzhi.id3;

import java.util.List;

import scut.houzhi.id3.util.AbsAttribute;

public class Record {
	private List<AbsAttribute> record;
	
	/**
	 * 记录
	 * @param record 一列属性，用integer 代替的属性。最后一条记录为类型代号
	 */
	public Record(List<AbsAttribute> record){
		this.setRecord(record);
	}
	
	public int size(){
		return record.size();
	}
	
	public List<AbsAttribute> getRecord() {
		return record;
	}
	public void setRecord(List<AbsAttribute> record) {
		this.record = record;
	}
	/**
	 * 获取第position 个属性的值
	 * @param position
	 * @return
	 */
	public AbsAttribute get(int position){
		return record.get(position);
	}
	
	public AbsAttribute getType(){
		return record.get(size()-1);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return record+"";
	}
	
	
}
