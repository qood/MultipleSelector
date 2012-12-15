package jp.kanja.mselector.catcher;

import java.util.HashMap;

import jp.kanja.mselector.MultiEvent;
import jp.kanja.mselector.MultipleSelector;
import jp.kanja.mselector.SelectorItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * OnTouchCatcher
 * @author qoo
 * for All Kinds of view
 */
public class OnTouchCatcher extends BaseEventCatcher implements OnTouchListener{

	/** Viewに対応するグループIDを保存 **/
	private HashMap<View, Integer> map = new HashMap<View, Integer>();

	public OnTouchCatcher(MultipleSelector selector_) {
		super(selector_);
	}

	public void registerItem(SelectorItem item){
		item.view.setOnTouchListener(this);
		map.put(item.view, item.groupId);
	}

	@Override
	public boolean onTouch(View view_, MotionEvent tEvent_) {
		return (Boolean) onEvent(view_, map.get(view_), new MultiEvent(MultiEvent.EVENT_TYPE_ONTOUCH, tEvent_));
	}
}
