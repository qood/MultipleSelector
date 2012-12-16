package jp.qood.mselector.catcher;

import java.util.HashMap;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;

import android.view.View;
import android.view.View.OnClickListener;

public class OnClickCatcher extends BaseEventCatcher implements OnClickListener{

	/** Viewに対応するグループIDを保存 **/
	private HashMap<View, Integer> map = new HashMap<View, Integer>();

	public OnClickCatcher(MultipleSelector selector_){
		super(selector_);
	}

	public void registerItem(SelectorItem item){
		item.view.setOnClickListener(this);
		map.put(item.view, item.groupId);
	}

	public void onClick(View view_){
		onEvent(view_, map.get(view_), new MultiEvent(MultiEvent.EVENT_TYPE_ONCLICK, null));
	}
}
