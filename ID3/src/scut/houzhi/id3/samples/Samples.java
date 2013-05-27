package scut.houzhi.id3.samples;

import java.util.ArrayList;
import java.util.List;

import com.houzhi.id3.ID3;
import com.houzhi.id3.Record;
import com.houzhi.id3.test.IrisRead;
import com.houzhi.id3.uitl.AttributeFactory;

public class Samples {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamplesRead read = new SamplesRead("samples.txt");
		List<Record> list = read.readRecordList();
		
		List<List<Integer>> attributeList = new ArrayList<List<Integer>>();
		attributeList.add(read.ageFactory.idList());
		attributeList.add(read.incomeFactory.idList());
		attributeList.add(read.studentFactory.idList());
		attributeList.add(read.creditFactory.idList());
		ID3<Float, String> id3 = new ID3(list,attributeList,  read.typeFactory.idList());
		id3.buildID3();
	} 
}
