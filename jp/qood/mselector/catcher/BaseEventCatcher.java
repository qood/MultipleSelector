package jp.qood.mselector.catcher;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;
import android.R.integer;
import android.view.View;

public abstract class BaseEventCatcher {

	private MultipleSelector selector;

	public BaseEventCatcher(MultipleSelector selector_){
		selector = selector_;
	}

	public Object onEvent(View view_, int groupId, MultiEvent event_){
		return selector.executeEventLoop(view_, groupId, event_);
	}

	public void release(){
		selector = null;
	}

	public abstract void registerItem(SelectorItem item);
}