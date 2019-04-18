/* HashTableChained.java */

package hw6.dict;
import hw6.list.*;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	public static final int DEFAULT = 101;
	public int numberOfBuckets;									// N
	protected List[] buckets;
	public int size;														// number of entries.
	public int collisions;											// number of collisions.
	
	
	


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
  	numberOfBuckets = getPrime((int)(sizeEstimate / 0.75)); 			 //(N >= n/0.75).
  	buckets = new List[numberOfBuckets];
  	for (int i = 0; i < numberOfBuckets; i++) {
  		buckets[i] = new SList();
  		size = 0;
  		collisions = 0;
  	}
  }
  
  public int getPrime(int num) {
  	while (true) {
  		if (isPrime(num) ==true) {
  			return num;
  		} else {
  			num++;
  		}
  	}
  }
  
  public boolean isPrime(int num) {
  	if (num < 0 || num == 1) {
  		return false;
  	}
  	if (num == 2 || num == 3) {
  		return true;
  	}
  	for (int devisor = 2; devisor * devisor <= num; devisor++) {
  		if (num % devisor == 0) {
  			return false;
  		}
  	}
  	return true;
  }
  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
  	this(DEFAULT);
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    int comp = ((7777 * code + 77777) % 16908799) & numberOfBuckets;			// a = 7777, b = 77777, p = 16908799, N = numberOfBuckets.
    if (comp < 0) {
    	comp += numberOfBuckets;
    }
    return comp;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return size == 0;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
  	int keyCode = compFunction(key.hashCode());
  	Entry newEntry = new Entry();
  	newEntry.key = key;
  	newEntry.value = value;
  	buckets[keyCode].insertBack(key);
  	size ++;
    return newEntry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
  	int keyCode = compFunction(key.hashCode());
  	if (buckets[keyCode].length() == 0) {
  		return null;
  	}
  	ListNode node = buckets[keyCode].front();
  	while (node.isValidNode() == true) { 
  		try {
    		if (key.equals(((Entry)node.item()).key)) {
    			return (Entry)node.item();
    		} else {
    			node = node.next();
    		}
  		} catch (InvalidNodeException e) {
  			System.out.println("InvalidNodeException: " + e);
  		}
  	}
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
  	int keyCode = compFunction(key.hashCode());
  	ListNode target = buckets[keyCode].front();
  	if (buckets[keyCode].length() == 0) {
  		return null;
  	}
  	ListNode node = buckets[keyCode].front();
  	while (node.isValidNode() == true) {
  		try {
  			if (key.equals(((Entry)node.item()).key)) {
  				target.setItem(node.item());
  				node.remove();
  				size--;
  				return (Entry)target.item();
  			} else {
  				node = node.next();
  			}
  		} catch (InvalidNodeException e) {
  				System.out.println("InvalidNodeException: " + e);
  			}
  	}
  	return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
  	for (List l : buckets) {
  		if (l.length() != 0) {
  			while (l.length() > 0) {
  				try {
  	  			ListNode current = l.front();
  	  			current.remove();
  	  			size--;
  				} catch (InvalidNodeException e) {
    				System.out.println("InvalidNodeException: " + e);
    			}
  			}
  		}
  	}
  }

}
