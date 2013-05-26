package scut.houzhi.id3.struct;

import java.util.HashMap;
import java.util.Map;

import scut.houzhi.id3.struct.ID3Node;
import scut.houzhi.id3.util.AbsAttribute;

public class ID3ComponentNode extends ID3Node{
    private ID3Node iD3Node;

    private int classifyAttributeFactory;

    private int attributeIndex;

    private Map<Integer, ID3Node> classifyMap;

    public boolean addChild(ID3Node ID3Node){
        // TODO put your implementation here.
    	return false;
    }
    
    /**
     * 找到子节点
     * @param attribute
     * @return
     */
    public ID3Node nextNode(AbsAttribute attribute){
        // TODO put your implementation here.
    	return null;
    }
	
	public ID3ComponentNode(int attributeIndex){
		super(false);
		classifyMap = new HashMap<Integer, ID3Node>();
		this.attributeIndex = attributeIndex;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
}