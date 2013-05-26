package scut.houzhi.id3.struct;

import scut.houzhi.id3.struct.ID3Node;
import scut.houzhi.id3.util.Type;

public class ID3LeafNode extends ID3Node{
    private Type type;

    public Type getType(){
        return type;
    }
	
    public ID3LeafNode( Type type){
    	super(true);
    }

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
    
}