/**
 * 属性类，所有的属性都继承这个类
 * 其中每个属性值对应一个id 必须保证id不一样。
 */
package com.id3;

import java.util.List;

public abstract class Attribute<T>  {
	protected List<T> listAttribute;
	
	/**
	 *
	 * @param t 总共的属性集
	 */
	public Attribute(List<T> t){
		listAttribute = t;
	}
	/**
	 * 获得标志，将各种属性类型，统一转变成装箱类型Integer
	 * @return
	 */
	public abstract Integer id(T t);
	
	
	/**
	 * 所有的id标号 改标号的长度应该与amount() 相同。即标号集
	 * @return
	 */
	public abstract List<Integer> idList();
	
	/**
	 * 找到 该id 在所有id 中的位置
	 * @param id
	 * @return
	 */
	public abstract int idPosition(Integer id);
}
