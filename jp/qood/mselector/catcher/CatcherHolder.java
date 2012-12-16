package jp.qood.mselector.catcher;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;

public class CatcherHolder {

	private MultipleSelector mSelector = null;

	private OnClickCatcher mClickCatcher = null;
	private OnTouchCatcher mTouchCatcher = null;

	public CatcherHolder(MultipleSelector selector_){
		this.mSelector = selector_;
	}

	public void registerItem(SelectorItem item_){

		switch (item_.eventType) {

		case MultiEvent.EVENT_TYPE_ONCLICK:
			if(mClickCatcher == null){
				mClickCatcher = new OnClickCatcher(mSelector);
			}
			mClickCatcher.registerItem(item_);
			break;
		case MultiEvent.EVENT_TYPE_ONTOUCH:

			break;
		default:
			break;
		}
	}
}
