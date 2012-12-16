package jp.qood.mselector;

public class MultipleSelectorListenerItem {

	public static final int PROPERTY_EXECUTE_SINGLE_VIEW = 0;
	public static final int PROPERTY_EXECUTE_ALL_VIEW = 1;

	public MultipleSelectorListener listener;
	public int property = 0;

	public MultipleSelectorListenerItem(MultipleSelectorListener listener_, int property_){
		listener = listener_;
		property = property_;
	}

}
