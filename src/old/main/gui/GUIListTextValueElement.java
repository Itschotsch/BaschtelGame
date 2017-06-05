package main.general.gui;

public class GUIListTextValueElement extends GUIListTextElement {
	
	Object secondValue;
	
	public GUIListTextValueElement(GUIListTextValueElement other) {
		super(other);
		this.secondValue = other.secondValue;
	}
	
	public GUIListTextValueElement(String text, Object value) {
		super(text, value);
	}
	
	@Override
	public void setValues(Object... valueArray) {
		this.init(valueArray[0].toString());
		this.secondValue = valueArray[1];
	}
	
	@Override
	public Object[] getValues() {
		return new Object[]{this.text, this.secondValue};
	}
	
	public GUIListTextValueElement copy() {
		GUIListTextValueElement element = new GUIListTextValueElement(this);
		return element;
	}
	
}
