package jp.qood.mselector;

import java.util.ArrayList;

import jp.qood.mselector.catcher.CatcherHolder;

import android.util.SparseArray;
import android.view.View;

/**
 * MultipleSelector
 * 本体クラス。インスタンス化して使う
 * @author qood
 */
public class MultipleSelector {

	/** デフォルトのグループID **/
	public static final int DEFAULT_GROUP_ID = -1;
	//public static MultipleSelector instance;

	/** Viewアイテムグループ **/
	private SparseArray<SelectorItemGroup> mItemGroups = null;

	/** 通知先リスナアイテムのリスト **/
	private ArrayList<MultipleSelectorListenerItem> mListenerArray = null;

	/** イベントキャッチャーを保持 **/
	private CatcherHolder mCatcherHolder;

	/**
	 * Constructor
	 */
	public MultipleSelector(){
		mListenerArray = new ArrayList<MultipleSelectorListenerItem>();
		mItemGroups = new SparseArray<SelectorItemGroup>();
		mCatcherHolder = new CatcherHolder(this);
	}

	/**
	 * 通知先の登録（プロパティはsingleViewになる）
	 * @param listener_
	 */
	public void addMulitipleSelectorListener(MultipleSelectorListener listener_){
		addMulitipleSelectorListener(listener_, MultipleSelectorListenerItem.PROPERTY_EXECUTE_SINGLE_VIEW);
	}

	/**
	 * プロパティーを指定して、通知先の登録
	 * @param listener_
	 * @param property_
	 */
	public void addMulitipleSelectorListener(MultipleSelectorListener listener_, int property_){
		mListenerArray.add( new MultipleSelectorListenerItem(listener_, property_) );
	}

	/**
	 * 対象Viewをデフォルトグループ(0)に登録
	 * @param view_
	 * @param eventType_
	 */
	public void addItem(View view_, int eventType_){
		addItem(view_, eventType_, DEFAULT_GROUP_ID);
	}

	/**
	 * 指定グループ（not 0）ターゲットViewの追加
	 * @param view_
	 * @param eventType_
	 * @param groupName_
	 */
	public void addItem(View view_, int eventType_, int groupId_){
		// 新規グループを作成
		if( mItemGroups.get(groupId_) == null){
			SelectorItemGroup newGroup = new SelectorItemGroup(groupId_);
			mItemGroups.put(groupId_, newGroup);
		}
		SelectorItem item = new SelectorItem(view_, eventType_, groupId_);
		mItemGroups.get(groupId_).add(item);
		mCatcherHolder.registerItem(item);
	}

	/**
	 * イベント発生をリスナに伝える
	 * @param view_
	 * @param event_
	 * @return
	 */
	public Object executeEventLoop(View view_, int groupId, MultiEvent event_){
		for(MultipleSelectorListenerItem listenerItem : mListenerArray){
			listenerItem.listener.onEvent(view_, event_);
			if(listenerItem.property == MultipleSelectorListenerItem.PROPERTY_EXECUTE_ALL_VIEW){
				ArrayList<SelectorItem> group = mItemGroups.get(groupId).getItemArray();
				for(SelectorItem item : group){
					if(item.view != view_){
						listenerItem.listener.onEventOthers(item.view, view_, event_);
					}
				}
			}
		}
		return null;
	}
}
