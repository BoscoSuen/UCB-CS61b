/* Set.java */
package hw5;
import hw5.list.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
	public List setList;
	public ListNode insertNode;			// the node that inserted.
  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements 
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set. 
   *
   *  Performance:  runs in O(1) time.
   **/
  public Set() { 
    // Your solution here.
	setList = new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
    return this.setList.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *
   *  Performance:  runs in O(this.cardinality()) time.
   **/
  public void insert(Comparable c) throws InvalidNodeException {
    // Your solution here.
  	ListNode location = this.setList.front();
  	partInsert(location,c);
  }

  public void partInsert(ListNode location, Comparable c) throws InvalidNodeException {
  	boolean inserted = false;
		ListNode current = location;
  	if(this.cardinality() == 0) {
  		setList.insertBack(c);
  		insertNode = setList.front();
  	} else {
  		while(current.next().isValidNode() == true) {
  			if (c.compareTo(current.item()) < 0) {
  				inserted = true;
  				current.insertBefore(c);
  				insertNode = current.prev();
  			}
  			if (c.compareTo(current.item()) == 0) {
  				inserted = true;			// do not need to insert this one.
  				break;
  			}
  			if (c.compareTo(current.item()) > 0 && c.compareTo(current.next().item()) < 0) {
  				current.insertAfter(c);
  				insertNode = current.next();
  				inserted = true;
  				break;
  			}
  			current = current.next();			// the last condition will be bigger than the last one.
  		}
  		if (c.compareTo(current.item()) == 0) {			//consider the last one(or length = 1).
  			inserted = true;
  		}
  		if (c.compareTo(current.item()) < 0) {			//consider length = 1.
  			inserted = true;
  			current.insertBefore(c);
  			insertNode = current.prev();
  		}
  		if (inserted == false) {								// insert it in the end.
  			current.insertAfter(c);
  			insertNode = current.next();
  		}
  	}
  }
  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
   **/
  public void union(Set s) throws InvalidNodeException {
    // Your solution here.

  	System.out.println("this is: " + this);
  	if(s.cardinality() != 0) {
  		ListNode current = s.setList.front();
  		System.out.println("The first current is: " + current.item());
  		ListNode location = current;
  		while(current.next().isValidNode() == true) {
  			System.out.println("the current is: " + current.item());
  			partInsert(location,(Comparable)current.item());
  			// the current node is the "this" list is insertNode.
  			location = insertNode;
  			System.out.println("the location is: " + location.item());
  			current = current.next();
  		}
  		partInsert(location,(Comparable)current.item()); 			//the last item in the s.setList.
  	}
  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
   **/
  public void intersect(Set s) {
    // Your solution here.
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/
  public String toString() {
    // Replace the following line with your solution.
    return setList.toString();
  }

  public static void main(String[] argv) throws InvalidNodeException {
    Set s1 = new Set();
    System.out.println("The empty list is: " + s1);
    s1.insert(new Integer(3));
    s1.insert(new Integer(4));
    s1.insert(new Integer(3));
    System.out.println("Set s1 = " + s1);

    Set s2 = new Set();
    s2.insert(new Integer(4));
    s2.insert(new Integer(5));
    s2.insert(new Integer(5));
    System.out.println("Set s2 = " + s2);
    
    Set s3 = new Set();
    s3.insert(new Integer(5));
    s3.insert(new Integer(3));
    s3.insert(new Integer(8));
    System.out.println("Set s3 = " + s3);

    s1.union(s2);
    System.out.println("After s1.union(s2), s1 = " + s1);
  
    s1.intersect(s3);
    System.out.println("After s1.intersect(s3), s1 = " + s1);
    System.out.println("s.cardinality() = " + s1.cardinality());
    // You may want to add more (ungraded) test code here.
  }
}
