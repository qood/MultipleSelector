package jp.kanja.mselector;

public class MultiEvent {

	public static final int EVENT_TYPE_ONCLICK = 0;
	public static final int EVENT_TYPE_ONTOUCH = 1;

	public int eventType;
	public Object eventObject;

	private MultiEvent(){
	}

	public MultiEvent(int eventType_, Object object_){
		this();
		eventType =eventType_;
		eventObject = object_;
	}
}
