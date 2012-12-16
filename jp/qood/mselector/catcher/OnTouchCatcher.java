package jp.qood.mselector.catcher;

import java.util.HashMap;

import jp.qood.mselector.MultiEvent;
import jp.qood.mselector.MultipleSelector;
import jp.qood.mselector.SelectorItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * OnTouchCatcher
 * @author qood
 * for All Kinds of view
 */
public class OnTouchCatcher extends BaseEventCatcher implements OnTouchListener{

	/** Viewに対応するグループIDを保存 **/
	private HashMap<View, Integer> mIDHashMap = new HashMap<View, Integer>();

	/**
	 * Constructor
	 * @param selector_
	 */
	public OnTouchCatcher(MultipleSelector selector_) {
		super(selector_);
	}

	public void registerItem(SelectorItem item){
		item.view.setOnTouchListener(this);
		mIDHashMap.put(item.view, item.groupId);
	}

	@Override
	public boolean onTouch(View view_, MotionEvent touchEvent_) {
		return (Boolean) onEvent(view_, mIDHashMap.get(view_), new MultiEvent(MultiEvent.EVENT_TYPE_ONTOUCH, touchEvent_));
	}
}
