/**
 * 属性类，所有的属性都继承这个类
 * 其中每个属性值对应一个id 必须保证id不一样。
 */
package com.houzhi.id3.uitl;

import java.util.ArrayList;
import java.util.List;

public abstract class AttributeFactory<T>  {
	protected List<T> listAttribute;
	protected List<Integer> listId;
	/**
	 *
	 * @param t 总共的属性集
	 */
	public AttributeFactory(List<T> t){
		listAttribute = new ArrayList<T>(t);
		listId = new ArrayList<Integer>();
		for(int i=0;i!=listAttribute.size();++i){
			listId.add(i);
		}
	}
	
	public List<T> getListAttribute(){
		return new ArrayList<T>(listAttribute);
	}
	
	/**
	 * 获得标志，将各种属性类型，统一转变成装箱类型Integer
	 * @return
	 */
	public Integer id(T t){
		return listAttribute.indexOf(t);
	}
	
	
	/**
	 * 所有的id标号 改标号的长度应该与amount() 相同。即标号集
	 * @return
	 */
	public List<Integer> idList(){
		return listId;
	}
	
	/**
	 * 找到 该id 在所有id 中的位置
	 * @param id
	 * @return
	 */
	public int idPosition(Integer id){
		return id;
	}
	/**
	 * 产生一个属性 -1 代表为根
	 * @param id
	 * @return
	 */
	public Attribute factory(int id){
		return new Attribute(id);
	}
	
	public Attribute factory(T t){
		return factory(listAttribute.indexOf(t));
	}
}
