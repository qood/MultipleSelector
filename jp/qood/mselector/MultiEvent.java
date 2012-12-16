package jp.qood.mselector;

public class MultiEvent {

	/** クリックイベント **/
	public static final int EVENT_TYPE_ONCLICK = 0;
	/** タッチイベント **/
	public static final int EVENT_TYPE_ONTOUCH = 1;

	/** イベントの種類 **/
	public int mEventType;
	/** イベントタイプに対応したオブジェクト **/
	public Object mEventObject;

	/**
	 * Constructor
	 */
	private MultiEvent(){
	}

	/**
	 * Constructor
	 * @param eventType_ イベントの種類
	 * @param object_ イベントオブジェクト
	 */
	public MultiEvent(int eventType_, Object object_){
		this();
		mEventType =eventType_;
		mEventObject = object_;
	}
}
