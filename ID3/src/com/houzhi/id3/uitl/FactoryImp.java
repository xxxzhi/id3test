package com.houzhi.id3.uitl;

import java.util.ArrayList;
import java.util.List;

public interface FactoryImp<T> {

	public List<T> getListAttribute();
	
	/**
	 * 获得标志，将各种属性类型，统一转变成装箱类型Integer
	 * @return
	 */
	public Integer id(T t);
	
	
	/**
	 * 所有的id标号 改标号的长度应该与amount() 相同。即标号集
	 * @return
	 */
	public List<Integer> idList();
	
	/**
	 * 找到 该id 在所有id 中的位置
	 * @param id
	 * @return
	 */
	public int idPosition(Integer id);
	/**
	 * 产生一个属性
	 * @param id
	 * @return
	 */
	public Attribute factory(int id);
	
	
	public Attribute factory(T t);
}
