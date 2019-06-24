import java.util.ArrayList;


/** abstract AbstractBinaryTree class
 *  extends AbstractTree class and implements BinaryTree interface */

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {

	/** method sibling 
	 *  returns the node of n's sibling or null if no sibling exists
	 *  @param n    a valid node within the tree
	 *  @return the node of the sibling or null if no sibling exists
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public Node<T> sibling(Node<T> n) {
		Node<T> parent = parent(n);
		if (parent == null) { return null; }          // n must be the root
		if (n == left(parent)){                       // n is a left child
			return right(parent);                       // right child might be null
		} else {                                      // n is a right child
			return left(parent);                        // left child might be null
		}
	}

	/** method numChildren
	 *  returns the number of children of node n
	 *  @param n    a valid Node within the tree
	 *  @return number of children of node n
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public int numChildren(Node<T> n) {
		int count = 0;
		if (left(n) != null) {
			count++; 
		}
		if (right(n) != null) {
			count++;
		}
		return count;
	}

	/** method children
	 *  returns an iterable collection of the n's child nodes
	 *  @param n    a valid node within the tree
	 *  @return iterable collection of the n's child nodes
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public Iterable<Node<T>> children(Node<T> n) {
		ArrayList<Node<T>> snapshot = new ArrayList<>(2);    // max capacity of 2
		if (left(n) != null) {
			snapshot.add(left(n));}
		if (right(n) != null) {
			snapshot.add(right(n));}
		return snapshot;
	}

	/** method inorderSubtree
	 *  adds nodes of the subtree rooted at node n to the given
	 *  snapshot using an inorder traversal
	 *  @param n    node serving as the root of a subtree
	 *  @param snapshot    a list to which results are appended */
	private void inorderSubtree(Node<T> n, ArrayList<Node<T>> snapshot) {
		if (left(n) != null) {
			inorderSubtree(left(n), snapshot);
		}
		snapshot.add(n);
		if (right(n) != null){
			inorderSubtree(right(n), snapshot);
		}
	}

	/** method inorder
	 *  returns an iterable collection of nodes of the tree, reported in inorder
	 *  @return iterable collection of the tree's nodes reported in inorder */
	public Iterable<Node<T>> inorder() {
		ArrayList<Node<T>> snapshot = new ArrayList<>();
		if (!isEmpty()) {
			inorderSubtree(root(), snapshot);         // fill the snapshot recursively
		}
		return snapshot;
	}

	/** method nodes
	 *  returns an iterable collection of the nodes of the tree
	 *  @return iterable collection of the tree's nodes */
	@Override
	public Iterable<Node<T>> nodes() {
		return inorder();
	}
}

