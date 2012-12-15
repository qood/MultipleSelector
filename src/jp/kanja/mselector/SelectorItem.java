package jp.kanja.mselector;

import android.view.View;

public class SelectorItem {

	public View view;
	public int eventType;
	public int groupId;

	public SelectorItem(View view_, int eventType_, int groupId_){
		this.view = view_;
		this.eventType = eventType_;
		this.groupId = groupId_;
	}
}
