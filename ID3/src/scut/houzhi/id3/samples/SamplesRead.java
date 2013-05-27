package scut.houzhi.id3.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import scut.houzhi.id3.util.AbsAttribute;

import com.houzhi.id3.Record;
import com.houzhi.id3.io.IORead;

public class SamplesRead extends IORead {
	 AgeFactory ageFactory;
	 CreditFactory creditFactory;
	 StudentFactory studentFactory;
	 IncomeFactory incomeFactory;
	 BuysTypeFactory typeFactory;
	public SamplesRead(String name) {
		super(name);
		List<String> t;
		t = new ArrayList<String>();
		t.add("<=30");
		t.add("31…40");
		t.add(">40");
		ageFactory = new AgeFactory(t);
		
		t = new ArrayList<String>();
		t.add("fair");
		t.add("excellent");
		creditFactory = new CreditFactory(t);
		
		t = new ArrayList<String>();
		t.add("yes");
		t.add("no");
		studentFactory = new StudentFactory(t);
		
		t = new ArrayList<String>();
		t.add("high");
		t.add("medium");
		t.add("low");
		incomeFactory = new IncomeFactory(t);
		
		t = new ArrayList<String>();
		t.add("yes");
		t.add("no");
		typeFactory = new BuysTypeFactory(t);
		
	}

	@Override
	public Record readRecord() {
		Record record = null;
		try {
			String line = reader.readLine();
			if(line==null){
				return null;
			}
			String values[] = line.split("\t");
			List<AbsAttribute> list = new ArrayList<AbsAttribute>();
			list.add(ageFactory.factory(values[0]));
			list.add(incomeFactory.factory(values[1]));
			list.add(studentFactory.factory( values[2]));
			list.add(creditFactory.factory(values[3]));
			
			list.add(typeFactory.factory(values[4]));
			
			record = new Record(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public List<Record> readRecordList() {
		Record record = null;
		List<Record> list = new ArrayList<Record>();
		while(true){
			record = readRecord();
			if(record!=null){
				list.add(record);
			}else{
				break;
			}
		}
		return list;
	}

}
