

/** ArrayQueue class
 *  implements the Queue ADT by using an array */

public class ArrayQueue<T> implements Queue<T> {

	/* instance variables */
	/** default array capacity */ 
	private static final int MAX_CAPACITY = 10;

	/** generic array used for storage */
	private T[] data;

	/** index of the front element in queue */
	private int f = 0;
	private int sz = 0;

	/* constructors */
	/** constructs queue with default max capacity */
	public ArrayQueue() {this(MAX_CAPACITY);}

	/** constructs queue with given capacity */
	@SuppressWarnings({"unchecked"})
	public ArrayQueue(int capacity) {
		data = (T[]) new Object[capacity];   // safe cast
	}

	/** method size
	 *  returns the number of elements in the queue
	 *  @return number of elements in the queue */
	public int size() {
		return sz;
	}

	/** method isEmpty
	 *  tests whether the queue is empty
	 *  @return true if the queue is empty, false otherwise */
	public boolean isEmpty() {
		return (sz == 0);
	}

	/** method first
	 *  returns, but does not remove, the first element of the queue
	 *  @return the first element of the queue (or null if empty) */
	public T first() {
		if (isEmpty()) {
			return null;
		}
		return data[f];
	}

	/** method enqueue
	 *  inserts an element at the rear of the queue
	 *  @param e    the element to be inserted */
	public void enqueue(T e) throws IllegalStateException {
		if (size() == data.length) {
			throw new IllegalStateException("The queue is full");
		}
		int r = (f + sz) % data.length;
		data[r] = e; 
		sz++;
	}

	/** method dequeue
	 *  removes and returns the first element of the queue
	 *  @return element removed (or null if empty) */
	public T dequeue() {
		if (isEmpty()) { return null; }
		T answer = data[f];
		//deference to help garbage collection
		data[f] = null;
		f = (f + 1) % data.length;
		sz--;
		return answer;
	}

	/** method toString
	 *  produces a string representation of the contents of the indexed list
	 *  @return textual representation of the queue */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		if ((f+sz) <= data.length) {
			for (int j = f; j < f + sz; j++) {
				if (j > f) {
					sb.append(", "); 
				}
				sb.append(data[j]);
			}
		} else {
			for (int j = f; j < data.length ; j++) {
				if(j > f) {
					sb.append(", ");
				}
				sb.append(data[j]);
			}
			for (int j = 0; j < (f + sz) % data.length; j++) {
				sb.append(", ");
				sb.append(data[j]);
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
