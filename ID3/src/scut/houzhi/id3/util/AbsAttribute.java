package scut.houzhi.id3.util;


public abstract class AbsAttribute{
    private int value = 0;
    
    public AbsAttribute(int v){
    	this.value = v;
    }
    
    public int getValue(){
    	return value;
    }
	
}