package jp.qood.mselector;

public class MultipleSelectorListenerItem {

	/** イベントが発生したビューのみリスナが呼ばれる **/
	public static final int PROPERTY_EXECUTE_SINGLE_VIEW = 0;
	/** グループ内のどれかひとつにイベントが発生したとき、同じグループの他のアイテムに対してもメソッドが呼ばれる **/
	public static final int PROPERTY_EXECUTE_ALL_VIEW = 1;

	/** リスナ **/
	public MultipleSelectorListener listener;
	/** プロパティの種類 **/
	public int property = 0;

	/**
	 * Constructor
	 * @param listener_ リスナ
	 * @param property_ プロパティ
	 */
	public MultipleSelectorListenerItem(MultipleSelectorListener listener_, int property_){
		this.listener = listener_;
		this.property = property_;
	}
}
