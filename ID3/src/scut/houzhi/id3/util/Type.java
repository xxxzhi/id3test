package scut.houzhi.id3.util;

import scut.houzhi.id3.util.AbsAttribute;

public class Type extends AbsAttribute{

	public Type(int v) {
		super(v);
		// TODO Auto-generated constructor stub
	}
	private boolean isAll = false;
	public Type initAll() {
		// TODO Auto-generated method stub
		setAll(true);
		return this;
	}
	public boolean isAll() {
		return isAll;
	}
	public void setAll(boolean isAll) {
		this.isAll = isAll;
	}
}