package jp.qood.mselector;

import android.view.View;

public interface MultipleSelectorListener {

	/** イベントが発生したViewの処理 **/
	public Object onEvent(View view, MultiEvent event);

	/** 同じグループでイベントが発生したときに、グループメンバそれぞれに対して順番に呼ばれる **/
	public void onEventOthers(View view, View targetedView, MultiEvent event);

}
