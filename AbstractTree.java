import java.util.Iterator;
import java.util.ArrayList;    // for use as snapshot iterator


/** abstract AbstractTree class
 *  implements the Tree interface */

public abstract class AbstractTree<T> implements Tree<T> {

	/** method isInternal
	 *  returns true if node n has one or more children
	 *  @param n    a valid node within the tree
	 *  @return true if n has at least one child, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public boolean isInternal(Node<T> n) { return numChildren(n) > 0;}

	/** method isExternal
	 *  returns true if node n does not have any children
	 *  @param n    a valid Node within the tree
	 *  @return true if n has zero children, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public boolean isExternal(Node<T> n) { return numChildren(n) == 0; }

	/** method isRoot
	 *  returns true if node n is the root of the tree
	 *  @param n    a valid node within the tree
	 *  @return true if n is the root of the tree, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public boolean isRoot(Node<T> n) { return n == root(); }

	/** method numChildren
	 *  returns the number of children of node n
	 *  @param n    a valid Node within the tree
	 *  @return number of children of node n
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public int numChildren(Node<T> n) {
		int count = 0;
		for (Node<T> child : children(n)) { count++; }
		return count;
	}

	/** method size
	 *  returns the number of nodes in the tree
	 *  @return number of nodes in the tree */
	@Override
	public int size() {
		int count = 0;
		for (Node<T> node : nodes()) { count++; }
		return count;
	}

	/** method isEmpty
	 *  tests whether the tree is empty
	 *  @return true if the tree is empty, false otherwise */
	@Override
	public boolean isEmpty() { return size() == 0; }


	/** method depth
	 *  Returns the number of levels separating Node p from the root
	 *  @param n    a valid node within the tree
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	public int depth(Node<T> n) throws IllegalArgumentException {
		if (isRoot(n)) {
			return 0;
		} else { 
			return 1 + depth(parent(n));}
	}

	/** method height
	 *  returns the height of the subtree rooted at node n
	 *  @param n    a valid Node within the tree
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	public int height(Node<T> n) throws IllegalArgumentException {
		int h = 0;                          // base case if n is external
		for (Node<T> child : children(n))
			h = Math.max(h, 1 + height(child));
		return h;
	}

	/* nested ElementIterator class */
	/** this class adapts the iteration produced by nodes() to return elements */
	private class ElementIterator implements Iterator<T> {
		Iterator<Node<T>> nodeIterator = nodes().iterator();
		public boolean hasNext() { return nodeIterator.hasNext(); }
		public T next() { return nodeIterator.next().getElement(); }  // return element!
		public void remove() { nodeIterator.remove(); }
	}

	/** method iterator
	 *  returns an iterator of the elements stored in the tree
	 *  @return iterator of the tree's elements */
	@Override
	public Iterator<T> iterator() { return new ElementIterator(); }

	/** method nodes
	 *  returns an iterable collection of the nodes of the tree
	 *  @return iterable collection of the tree's nodes */
	@Override
	public Iterable<Node<T>> nodes() { return preorder(); }

	/** method preorderSubtree
	 *  adds nodes of the subtree rooted at node n to the given
	 *  snapshot using a preorder traversal
	 *  @param n    node serving as the root of a subtree
	 *  @param snapshot    a list to which results are appended */
	private void preorderSubtree(Node<T> n, ArrayList<Node<T>> snapshot) {
		snapshot.add(n);     // for preorder, we add node n before exploring subtrees
		for (Node<T> child : children(n)) { preorderSubtree(child, snapshot); }
	}

	/** method preorder
	 *  returns an iterable collection of nodes of the tree, reported in preorder
	 *  @return iterable collection of the tree's nodes in preorder */
	public Iterable<Node<T>> preorder() {
		ArrayList<Node<T>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			preorderSubtree(root(), snapshot);     // fill the snapshot recursively
		}	 
		return snapshot;
	}

	/** method postorderSubtree
	 *  adds nodes of the subtree rooted at node n to the given
	 *  snapshot using a postorder traversal
	 *  @param n    node serving as the root of a subtree
	 *  @param snapshot    a list to which results are appended */
	private void postorderSubtree(Node<T> n, ArrayList<Node<T>> snapshot) {
		for (Node<T> child : children(n)) {
			postorderSubtree(child, snapshot);
		}
		snapshot.add(n);     // for postorder, we add node p after exploring subtrees
	}

	/** method postorder
	 *  returns an iterable collection of nodes of the tree, reported in postorder
	 *  @return iterable collection of the tree's nodes in postorder */
	public Iterable<Node<T>> postorder() {
		ArrayList<Node<T>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			postorderSubtree(root(), snapshot);     // fill the snapshot recursively
		} 
		return snapshot;
	}

	/** method breadthfirst
	 *  returns an iterable collection of nodes of the tree in breadth-first order
	 *  @return iterable collection of the tree's nodes in breadth-first order */
	public Iterable<Node<T>> breadthfirst() {
		ArrayList<Node<T>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			ArrayQueue<Node<T>> fringe = new ArrayQueue<>();
			fringe.enqueue(root());                // start with the root
			while (!fringe.isEmpty()) {
				Node<T> n = fringe.dequeue();     // remove from front of the queue
				snapshot.add(n);                   // report this position
				for (Node<T> child : children(n))
					fringe.enqueue(child);         // add children to back of queue
			}
		}
		return snapshot;
	}
}