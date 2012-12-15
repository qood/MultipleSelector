package jp.kanja.mselector;

import java.util.ArrayList;

import jp.kanja.mselector.catcher.CatcherHolder;

import android.util.SparseArray;
import android.view.View;

/**
 * MultipleSelector
 * 本体クラス。インスタンス化して使う
 * @author Shohei Horiguchi
 *
 */
public class MultipleSelector {

	public static final int DEFAULT_GROUP_ID = -100;
	//public static MultipleSelector instance;

	/** Viewアイテムグループ **/
	private SparseArray<SelectorItemGroup> itemGroups;

	/** 通知先リスナアイテムのリスト **/
	private ArrayList<MultipleSelectorListenerItem> listeners;

	private CatcherHolder catcherHolder;

	/**
	 * Initializer
	 */
	public MultipleSelector(){
		listeners = new ArrayList<MultipleSelectorListenerItem>();
		itemGroups = new SparseArray<SelectorItemGroup>();
		catcherHolder = new CatcherHolder(this);
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
		listeners.add( new MultipleSelectorListenerItem(listener_, property_) );
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
		if( itemGroups.get(groupId_) == null){
			SelectorItemGroup newGroup = new SelectorItemGroup(groupId_);
			itemGroups.put(groupId_, newGroup);
		}
		SelectorItem item = new SelectorItem(view_, eventType_, groupId_);
		itemGroups.get(groupId_).add(item);
		catcherHolder.registerItem(item);
	}

	/**
	 * イベント発生をリスナに伝える
	 * @param view_
	 * @param event_
	 * @return
	 */
	public Object executeEventLoop(View view_, int groupId, MultiEvent event_){
		for(MultipleSelectorListenerItem listenerItem : listeners){
			listenerItem.listener.onEvent(view_, event_);
			if(listenerItem.property == MultipleSelectorListenerItem.PROPERTY_EXECUTE_ALL_VIEW){
				ArrayList<SelectorItem> group = itemGroups.get(groupId).items;
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
