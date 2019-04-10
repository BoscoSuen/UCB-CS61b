/*LockDList.java*/
/*hints: override newNode() and remove*/
package list;
public class LockDList extends DList {

	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);					
	}		
	
	public void remove(DListNode node) {
    if (node != null) {
    LockDListNode newnode = (LockDListNode)node;
    	if (!newnode.locked) { 	
    		super.remove(node);
			}
    }
  }
  
  public void lockNode(DListNode node) {
  	LockDListNode lknode = (LockDListNode)node;
  	lknode.locked = true;
  }
  
}
   
