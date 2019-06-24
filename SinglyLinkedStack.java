/* Stack
 * Singly-linked-list-based implementation */
import java.util.*;import java.lang.*;
public class SinglyLinkedStack <T> {
	/* create an empty singly linked list */
    
	List sll=new ArrayList();
        
        protected Node<T>first,last,head,tail;
        
	/* constructor */
	public SinglyLinkedStack() {first=null;last=null;head=null;tail=null;}
	
	/**method: size
	 * returns the number of elements in the stack 
	 * @return size */
	public int size() {
		return sll.size();
	}
	
	/**method: isEmpty
	 * returns a boolean indicating whether the stack is empty
	 * @return true if the stack is empty, false otherwise */
	public boolean isEmpty() {
		return sll.isEmpty();
	}
	
	/**method: top
	 * returns the top element of the stack, 
	 * without removing it or null if the stack if empty
	 * @return top element */
	public T top() {
		return sll.first();
	}
	
	/**method: pop
	 * removes and returns the top element 
	 * from the stack or null if the stack is empty
	 * @return the top element */
	public void push(T e) {
		sll.addFirst(e);
	}
	
	/**method: push
	 * adds element e to the top of the stack
	 * @param e */
	public T pop() {
		return sll.removeFirst();
	}
	
	/**method: toString
	 * produces a string representation of the contents of the indexed list
	 * @return textual representation of the stack */
	public String toString() {
		return sll.toString();
	}
}
