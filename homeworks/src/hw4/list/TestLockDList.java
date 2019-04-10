/*TestLockDList.java*/
package hw4.list;
public class TestLockDList {
  public static void main (String[] args) {
  	System.out.println("Testing the LockDList: ");
  	LockDList l = new LockDList();
  	// the following is same as TestDList.java */
  	TestHelper.verify(l.isEmpty() == true, "the new list is not an empty list!");
	TestHelper.verify(l.length() == 0, "the new list is not an empty list!");
	System.out.println();
		
	System.out.println("Test the insertFront and insertBack");
	l.insertFront(3);
	l.insertFront(1);
	l.insertBack(5);
	System.out.println("After insert 1 3 5, the list should be [  1  3  5  ]: \n" + l);
	TestHelper.verify(l.toString().equals("[  1  3  5  ]"),"insertFront and insertBack are not right!");				// when verifing, need to add toString().
	TestHelper.verify(l.length() == 3, "the list length is not right!");
	System.out.println();
		
	System.out.println("Test insertAfter and insertBefore");
	DListNode node = l.head.next.next;			// the node.item should be 3.
	l.insertBefore(2,l.head.next.next);
	l.insertAfter(4,node);
	System.out.println("After insert 2 and 3, the list should be [  1  2  3  4  5  ]: \n" +l);
	TestHelper.verify(l.toString().equals("[  1  2  3  4  5  ]"),"insertAfter and insertBefore are not right!");
	TestHelper.verify(l.length() == 5, "the list length is not right!");
	System.out.println();
	
	System.out.println("Test front and back");
	System.out.println("the front of the list should be 1: " + l.front().item);
	TestHelper.verify((int)l.front().item == 1, "the front of the list is not right!");
	System.out.println("the end of the list should be 5: " + l.back().item);
	TestHelper.verify((int)l.back().item == 5, "the end of the list is not right!");
	System.out.println();
	
	System.out.println("Test next and prev");
	System.out.println("the prev of the 1 should be null: " + l.prev(l.head.next));
	TestHelper.verify(l.prev(l.head.next) == null, "the prev is not right!");
	System.out.println("the prev of the 3 should be 2: " + l.prev(l.head.next.next.next).item);
	TestHelper.verify((int)l.prev(l.head.next.next.next).item == 2, "the prev is not right!");
	System.out.println("the next of the 5 should be null: " + l.next(l.head.prev));
	TestHelper.verify(l.next(l.head.prev) == null, "the next is not right!");
	System.out.println("the next of the 3 should be 4: " + l.next(l.head.next.next.next).item);
	TestHelper.verify((int)l.next(l.head.next.next.next).item == 4, "the next is not right!");
	System.out.println();
	
	System.out.println("Test remove");
	l.remove(null);
	System.out.println("After remove null, the list should not be changed: \n" + l);
	TestHelper.verify(l.toString().equals("[  1  2  3  4  5  ]"),"The result of removing null is not right!");
	l.remove(l.head.next.next);				// remove 2.
	System.out.println("After remove 2, the list should be [  1  3  4  5  ]: \n" + l);
	TestHelper.verify(l.toString().equals("[  1  3  4  5  ]"),"The result of removing 2 is not right!");
	TestHelper.verify(l.length() == 4, "the list length is not right!");
	
	// Now test the lock application:
	
	DListNode lknode = l.head.prev;					// lock "5".
	l.lockNode(lknode);
	l.remove(l.head.prev);
	System.out.println("When remove the locked node, the list should not be changed(should be [  1  3  4  5  ]): \n" + l);
	}
}
		
