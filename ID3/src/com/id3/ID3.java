package com.id3;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ID3 {
	private Set<Enum> setAttribute;
	
	public ID3(Set<Enum> setAttribute){
		this.setAttribute = setAttribute;
	}
	
	/**
	 * 建造id3
	 */
	public void buildID3(){
		buildID3Inner(new HashSet(setAttribute));
	}
	private void buildID3Inner(Set<Enum> copyAttribtes){
		
		Enum e = countAttributes(copyAttribtes);
		//构建树
		
		//删除属性
		copyAttribtes.remove(e);
	}
	
	public Enum countAttributes(Set<Enum> attributes){
		float entropy;
		float min = 0;			//计算最小熵
		Enum selectAttributes = null;
		for(Enum e:attributes){
			//计算熵值 并且比较获得最小熵的属性
			entropy = countEntropy(e);
			if(min>=entropy){
				min = entropy;
				selectAttributes = e;
			}
		}
		return selectAttributes;
	}
	
	//
	private float countEntropy(Enum attributes){
		return 0f;
	}
}
