package jp.qood.mselector.catcher;

import java.util.HashMap;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;

import android.view.View;
import android.view.View.OnClickListener;

public class OnClickCatcher extends BaseEventCatcher implements OnClickListener{

	/** Viewに対応するグループIDを保存 **/
	private HashMap<View, Integer> mIDHashMap = new HashMap<View, Integer>();

	/**
	 * Constructor
	 * @param selector_
	 */
	public OnClickCatcher(MultipleSelector selector_){
		super(selector_);
	}

	/**
	 * アイテムをリスナに登録する
	 */
	public void registerItem(SelectorItem item){
		item.view.setOnClickListener(this);
		mIDHashMap.put(item.view, item.groupId);
	}

	/**
	 * クリックイベントを受け取る
	 */
	@Override
	public void onClick(View view_){
		onEvent(view_, mIDHashMap.get(view_), new MultiEvent(MultiEvent.EVENT_TYPE_ONCLICK, null));
	}
}
