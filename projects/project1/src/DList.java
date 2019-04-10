/*DList.java*/
public class DList {
	
	protected DListNode head;
	protected DListNode tail;
	protected int size;
	
	public DList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void insertFront(int[] item) {
		if (head == null) {
			DListNode node = new DListNode(item);
			head = node;
			tail = node;
			size ++;
		} else {
			DListNode node = new DListNode(item);
			node.next = head;
			head.prev = node;
			head = node;
			size ++;
		}
	}
	
	public void insertBack(int[] item) {
		if (head == null) {
			DListNode node = new DListNode(item);
			head = node;
			tail = node;
			size ++;
		} else {
			DListNode node = new DListNode(item);
			node.prev = tail;
			tail.next = node;
			tail = node;
			size ++;
		}
	}
	
	public DListNode getHead() {
		return head;			// let other classes get the head.
	}
	
	public int getSize() {
		return size;
	}
}
