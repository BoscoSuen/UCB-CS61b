/* ListSorts.java */
package hw8;
import hw8.list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
  	LinkedQueue newQueue = new LinkedQueue();
  	try {
    	while (!q.isEmpty()) {
    		LinkedQueue sq = new LinkedQueue();
    		sq.enqueue(q.dequeue());
    		newQueue.enqueue(sq);
    	}
  	} catch (QueueEmptyException e) {
  		System.out.println(e);
  	}
    return newQueue;
  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
  	LinkedQueue merged = new LinkedQueue();
  	try {
    	while (!q1.isEmpty() && !q2.isEmpty()) {
    		Comparable item1 = (Comparable)q1.front();
    		Comparable item2 = (Comparable)q2.front();
    		if (item1.compareTo(item2) < 0) {
    			merged.enqueue(q1.dequeue());
    		} else if (item1.compareTo(item2) > 0) {
    			merged.enqueue(q2.dequeue());
    		} else {
    			merged.enqueue(q1.dequeue());
    			merged.enqueue(q2.dequeue());
    		}
    	}
    	if (q1.isEmpty() && !q2.isEmpty()) {
    		while (!q2.isEmpty()) {
    			merged.enqueue(q2.dequeue());
    		}
    	}
    	if (!q1.isEmpty() && q2.isEmpty()) {
    		while (!q1.isEmpty()) {
    			merged.enqueue(q1.dequeue());
    		}
    	}
  	} catch (QueueEmptyException e) {
  		System.out.println(e);
  	}
    return merged;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
  	while (!qIn.isEmpty()) {
  		try {
  			Comparable item = (Comparable)qIn.front();
  			if (item.compareTo(pivot) < 0) {
  				qSmall.enqueue(qIn.dequeue());
  			} else if (item.compareTo(pivot) == 0) {
  				qEquals.enqueue(qIn.dequeue());
  			} else {
  				qLarge.enqueue(qIn.dequeue());
  			}
  		} catch (QueueEmptyException e) {
  			System.out.println(e);
  		}
  	}
  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
  	LinkedQueue QofQ = makeQueueOfQueues(q);				// after this method, the q is empty.
  	try {
	  	while (QofQ.size() > 1) {
	  		LinkedQueue q1 = (LinkedQueue)QofQ.dequeue();
	  		LinkedQueue q2 = (LinkedQueue)QofQ.dequeue();
	  		LinkedQueue merged = mergeSortedQueues(q1,q2);
	  		QofQ.enqueue(merged);
	  	}
	  	q.append((LinkedQueue)QofQ.front());
  	} catch (QueueEmptyException e) {
  		System.out.println(e);
  	}
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
  	int pivetIndex = (int)(q.size() * Math.random());				// Math.random(): 0.0~1.0
  	LinkedQueue qSmall = new LinkedQueue();
  	LinkedQueue qEquals = new LinkedQueue();
  	LinkedQueue qLarge = new LinkedQueue();
  	Comparable pivot = (Comparable)q.nth(pivetIndex);
  	partition(q,pivot,qSmall,qEquals,qLarge);
  	if (qSmall.size() > 1) {
  		quickSort(qSmall);
  	}
  	if (qLarge.size() > 1) {
  		quickSort(qLarge);
  	}
  	q.append(qSmall);
  	q.append(qEquals);
  	q.append(qLarge);
  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {
  	System.out.println("Now test the mergesort algorithm: ");
    LinkedQueue q = makeRandom(10);
    System.out.println("The original queue is: \n" + q.toString());
    mergeSort(q);
    System.out.println("After mergesort, the queue is: \n" + q.toString());
    
    System.out.println();
    System.out.println("Now test the quicksort algorithm: ");
    q = makeRandom(10);
    System.out.println("The original queue is: \n" + q.toString());
    quickSort(q);
    System.out.println("After quicksort, the queue is: \n" + q.toString());

    /* Remove these comments for Part III.
    Timer stopWatch = new Timer();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    mergeSort(q);
    stopWatch.stop();
    System.out.println("Mergesort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");

    stopWatch.reset();
    q = makeRandom(SORTSIZE);
    stopWatch.start();
    quickSort(q);
    stopWatch.stop();
    System.out.println("Quicksort time, " + SORTSIZE + " Integers:  " +
                       stopWatch.elapsed() + " msec.");
    */
  }

}
