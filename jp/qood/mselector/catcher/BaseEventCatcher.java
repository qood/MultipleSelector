package jp.qood.mselector.catcher;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;
import android.view.View;

public abstract class BaseEventCatcher {

	private MultipleSelector mSelector;

	public BaseEventCatcher(MultipleSelector selector_){
		mSelector = selector_;
	}

	public Object onEvent(View view_, int groupId, MultiEvent event_){
		return mSelector.executeEventLoop(view_, groupId, event_);
	}

	/**
	 * MultipleSelectorを開放
	 */
	public void release(){
		mSelector = null;
	}

	/**
	 * キャッチャーをそれぞれのイベントリスナとして登録
	 * @param item
	 */
	public abstract void registerItem(SelectorItem item);
}
