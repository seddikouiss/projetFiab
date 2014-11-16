package fr.amu.appli;

public class BeanBoolean {
	
	boolean val ;

	public BeanBoolean() {
		this(false);
	}

	public BeanBoolean(boolean val) {
		this.val =val;
	}

	public boolean isVal() {
		return val;
	}

	public void setVal(boolean val) {
		this.val = val;
	}
	

}
