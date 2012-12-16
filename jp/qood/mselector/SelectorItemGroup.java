package jp.qood.mselector;

import java.util.ArrayList;

public class SelectorItemGroup {

	/** グループのID **/
	private int mGroupId;
	/** アイテム配列 **/
	private ArrayList<SelectorItem> mItemArray;

	/**
	 * Constructor
	 * @param groupId_
	 */
	public SelectorItemGroup(int groupId_){
		this.mGroupId = groupId_;
		this.mItemArray = new ArrayList<SelectorItem>();
	}

	/**
	 * アイテムを追加
	 * @param item_
	 */
	public void add(SelectorItem item_){
		mItemArray.add(item_);
	}

	public int getmGroupId() {
		return mGroupId;
	}

	public void setmGroupId(int mGroupId) {
		this.mGroupId = mGroupId;
	}

	public ArrayList<SelectorItem> getItemArray() {
		return mItemArray;
	}

	public void setItemArray(ArrayList<SelectorItem> itemArray_) {
		this.mItemArray = itemArray_;
	}
}
