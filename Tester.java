// Driver class to test array list and linked list
import java.util.*;import java.lang.*;
public class Tester {
	public static void main(String args[]) {
		List<Integer> al = new ArrayList<Integer>(10);
		System.out.println(al.size());
		System.out.println(al.isEmpty());
		//System.out.println(al.get(10));
		System.out.println(al.toString());
		al.add(0, 10);
		System.out.println(al.toString());
		al.add(1, 20);
		System.out.println(al.toString());
		al.add(2, 30);
		System.out.println(al.toString());
		System.out.println(al.remove(1));
		System.out.println(al.toString());
		
		
		//test singly linked list
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		System.out.println(sll.size());
		System.out.println(sll.toString());
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.removeFirst());
		System.out.println(sll.removeLast());
		sll.addFirst(1);
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		sll.addFirst(2);
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		sll.addFirst(3);
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		sll.addLast(4);
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		sll.addLast(5);
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		//System.out.println(sll.removeFirst());
		//System.out.println(sll.toString());
		//System.out.println(sll.removeFirst());
		//System.out.println(sll.toString());
		System.out.println(sll.removeLast());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		System.out.println(sll.removeLast());
		System.out.println(sll.last());
		System.out.println(sll.toString());		
		System.out.println(sll.removeLast());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		System.out.println(sll.removeLast());
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());
		System.out.println(sll.removeLast());
		System.out.println(sll.first());
		System.out.println(sll.last());
		System.out.println(sll.toString());	 */
		
		
		//test doubly linked list
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		System.out.println(dll.size());
		System.out.println(dll.toString());
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.removeFirst());
		System.out.println(dll.removeLast());
		dll.addFirst(100);
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		dll.addFirst(2);
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		dll.addFirst(3);
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		dll.addLast(4);
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		dll.addLast(5);
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		//System.out.println(dll.removeFirst());
		//System.out.println(dll.toString());
		//System.out.println(dll.removeFirst());
		//System.out.println(dll.toString());
		System.out.println(dll.removeLast());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		System.out.println(dll.removeLast());
		System.out.println(dll.last());
		System.out.println(dll.toString());		
		System.out.println(dll.removeLast());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		System.out.println(dll.removeLast());
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());
		System.out.println(dll.removeLast());
		System.out.println(dll.first());
		System.out.println(dll.last());
		System.out.println(dll.toString());	
		*/
		
		CircularlyLinkedList<Integer> cll = new CircularlyLinkedList<>();
		System.out.println(cll.size());
		System.out.println(cll.toString());
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.removeFirst());
		//System.out.println(cll.removeLast());
		cll.addFirst(1);
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		cll.addFirst(2);
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		cll.addFirst(3);
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		cll.addLast(4);
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		cll.addLast(5);
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		System.out.println(cll.removeFirst());
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString());
		System.out.println(cll.removeFirst());
		System.out.println(cll.first());
		System.out.println(cll.last());
		System.out.println(cll.toString()); */
	}
}
