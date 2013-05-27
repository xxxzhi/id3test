package scut.houzhi.id3.samples;

import java.util.List;

import scut.houzhi.id3.util.AbsAttribute;
import scut.houzhi.id3.util.AbsAttributeFactory;

public class StudentFactory extends AbsAttributeFactory<String> {

	public StudentFactory(List<String> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbsAttribute factory(int id) {
		// TODO Auto-generated method stub
		return new AbsAttribute(id) {
		};
	}

}
