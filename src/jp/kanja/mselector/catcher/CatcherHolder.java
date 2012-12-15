package jp.kanja.mselector.catcher;

import jp.kanja.mselector.MultiEvent;
import jp.kanja.mselector.MultipleSelector;
import jp.kanja.mselector.SelectorItem;

public class CatcherHolder {

	private MultipleSelector selector = null;

	private OnClickCatcher clickCatcher = null;
	private OnTouchCatcher touchCatcher = null;

	public CatcherHolder(MultipleSelector selector_){
		selector = selector_;
	}

	public void registerItem(SelectorItem item_){

		switch (item_.eventType) {

		case MultiEvent.EVENT_TYPE_ONCLICK:
			if(clickCatcher == null){
				clickCatcher = new OnClickCatcher(selector);
			}
			clickCatcher.registerItem(item_);
			break;
		case MultiEvent.EVENT_TYPE_ONTOUCH:

			break;
		default:
			break;
		}
	}
}
