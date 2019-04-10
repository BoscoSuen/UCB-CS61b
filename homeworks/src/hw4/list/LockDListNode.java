/*LockDListNode.java*/
/* Carry information about whether it has been locked. LockDListNodes are not locked when they are first created. */
package list;
public class LockDListNode extends DListNode {

	protected boolean locked;
	
	LockDListNode(Object i, DListNode p, DListNode n) {
		super(i, p, n);
		locked = false;
	}
}
