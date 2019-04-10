/*DListNode.java*/
public class DListNode {

	public int[] item;					// there are four parameters of the constructor. And this time r,g,b are ints.
	public DListNode prev;
	public DListNode next;
	
	public DListNode() {
		int[] item = new int[4];
		this.prev = null;
		this.next = null;
	}
	
	public DListNode(int[] item) {
		this.item = item;
		this.prev = null;
		this.next = null;
	}
	
}
