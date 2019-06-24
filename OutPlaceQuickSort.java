/* Quick sort: out-of-place, three-way partition, stable
 * 
 */

public class OutPlaceQuickSort {
	
	public SinglyLinkedQueue<Integer> outPlaceQuickSort(SinglyLinkedQueue<Integer> S) {
		
		int n = S.size();
		if (n < 2) {
			return null;
		}

		// divide
		Integer pivot = S.first(); // using the first element as the pivot
		// additional data structures
		SinglyLinkedQueue<Integer> L = new SinglyLinkedQueue<>();
		SinglyLinkedQueue<Integer> E = new SinglyLinkedQueue<>();
		SinglyLinkedQueue<Integer> G = new SinglyLinkedQueue<>();
		
		while (!S.isEmpty()) {
			// divide original sequence into L, E, and G
			Integer element = S.dequeue();
			if (element < pivot) {
				L.enqueue(element);
			} else if (element == pivot) {
				E.enqueue(element);
			} else {
				G.enqueue(element);
			}
		}
		
		// conquer: recursive solution
		outPlaceQuickSort(L);
		outPlaceQuickSort(G);
		
		// concatenate results
		while (!L.isEmpty()) {
			S.enqueue(L.dequeue());
		}
		while (!E.isEmpty()) {
			S.enqueue(E.dequeue());
		}
		while (!G.isEmpty()) {
			S.enqueue(G.dequeue());
		}
		// return sorted sequence
		return S;
	}
}
