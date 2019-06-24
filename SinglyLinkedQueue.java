
/* Queue
 * Linked list-based implementation
 */
import java.util.*;import java.lang.*;
public class SinglyLinkedQueue<T> {
	/* create an empty singly linked list */
	private final SinglyLinkedList<T> sll = new SinglyLinkedList<T>();
	
	/* constructor */
	public SinglyLinkedQueue() {}
	
	/**method: size
	 * returns the number of elements in the queue
	 * @return number of elements in the queue */
	public int size() {
		return sll.size();
	}
	
	/**method: isEmpty
	 * tests whether the queue is empty
	 * @return true if the queue is empty, false otherwise */
	public boolean isEmpty() {
		return sll.isEmpty();
	}
	
	/**method: first
	 * returns, but does not remove, the first element of the queue
	 * @return the first element of the queue (or null if empty) */
	public T first() {
		return sll.first();
	}
	
	/**method: enqueue
	 * inserts an element at the rear of the queue
	 * @param e  the element to be inserted */
	public void enqueue(T e) {
		sll.addLast(e);
	}
	
	/**method: dequeue
	 * removes and returns the first element of the queue
	 * @return element removed (or null if empty) */
	public T dequeue() {
		return sll.removeFirst();
	}
	
	/**method: toString
	 * produces a string representation of the contents of the indexed list
	 * @return textual representation of the queue */
	public String toString() {
		return sll.toString();
	}
}
