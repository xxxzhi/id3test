package scut.houzhi.id3.util;

import java.util.ArrayList;
import java.util.List;

import com.houzhi.id3.uitl.Attribute;

import scut.houzhi.id3.util.AbsAttribute;

public abstract class AbsAttributeFactory<T>{
    private AbsAttribute absAttribute;

    
//    public List<AbsAttribute> getListAttribute(){
//		return null;
//    }
	
    public List<T> getListSourceAttribute(){
    	return new ArrayList<T>(listAttribute);	
    }
	
	protected List<T> listAttribute;
	protected List<Integer> listId;
	/**
	 *
	 * @param t 总共的属性集
	 */
	public AbsAttributeFactory(List<T> t){
		listAttribute = new ArrayList<T>(t);
		listId = new ArrayList<Integer>();
		for(int i=0;i!=listAttribute.size();++i){
			listId.add(i);
		}
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
	public abstract AbsAttribute factory(int id);
	
	public AbsAttribute factory(T t){
		return factory(listAttribute.indexOf(t));
	}
}