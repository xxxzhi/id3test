package scut.houzhi.id3.struct;

import scut.houzhi.id3.struct.ID3ComponentNode;

public abstract class ID3Node{
    
    private boolean isLeaf ;
    public boolean isLeaf(){
    	return isLeaf;
    }
    public ID3Node(boolean isLeaf){
        // TODO put your implementation here.	
    }
	
    public abstract void print();
	
}