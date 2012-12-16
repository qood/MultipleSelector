package jp.qood.mselector;

import java.util.ArrayList;

public class SelectorItemGroup {
	int groupId;
	ArrayList<SelectorItem> items;

	public SelectorItemGroup(int groupId_){
		this.groupId = groupId_;
		items = new ArrayList<SelectorItem>();
	}

	public void add(SelectorItem item_){
		items.add(item_);
	}
}
