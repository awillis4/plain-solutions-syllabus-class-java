

/** LinkedBinaryTree class
 *  implements a binary tree by using a linked-based structure
 *  and extends AbstractBinaryTree class */

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

	/* nested Node class */
	/** nested static class for a binary tree node
	 *  implements Node interface. 
	 *  A node of a binary tree, stores a reference to its
	 *  element and to each child node in the tree or null if it has no children */
	private static class BinaryNode<T> implements Node<T> {

		/* instance variables */
		private T element;          // an element stored at this node
		private BinaryNode<T> parent;     // a reference to the parent node if any
		private BinaryNode<T> left;       // a reference to the left child if any
		private BinaryNode<T> right;      // a reference to the right child if any

		/* constructor */
		/** creates a binary tree node by specifying its element, parent node, and child nodes
		 *  @param e    the element to be stored
		 *  @param above    reference to a parent node
		 *  @param leftChild    reference to a left child node
		 *  @param rightChild    reference to a right child node */
		public BinaryNode(T e, BinaryNode<T> above, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}

		/* accessor methods */
		public T getElement() { return element; }
		public BinaryNode<T> getParent() { return parent; }
		public BinaryNode<T> getLeft() { return left; }
		public BinaryNode<T> getRight() { return right; }

		/*  methods */
		public void setElement(T e) { element = e; }
		public void setParent(BinaryNode<T> parentNode) { parent = parentNode; }
		public void setLeft(BinaryNode<T> leftChild) { left = leftChild; }
		public void setRight(BinaryNode<T> rightChild) { right = rightChild; }
	}  

	/** utility method createNode
	 *  creates a binary tree node by specifying its element, parent node, and child nodes
	 *  @param e    the element to be stored
	 *  @param above    reference to a parent node
	 *  @param leftChild    reference to a left child node
	 *  @param rightChild    reference to a right child node 
	 *  @return a new binary node */
	private BinaryNode<T> createNode(T e, BinaryNode<T> parent, BinaryNode<T> left, BinaryNode<T> right) {
		return new BinaryNode<T>(e, parent, left, right);
	}

	/* instance variables of LinkedBinaryTree */
	/** the root of the binary tree */
	private BinaryNode<T> root = null;      // root of the tree

	/** the number of nodes in the binary tree */
	private int size = 0;              // number of nodes in the tree

	/* constructor */
	/** constructs an empty binary tree */
	public LinkedBinaryTree() { }      // constructs an empty binary tree

	/* non-public utility methods */
	/** method validate
	 *  verifies that a node belongs to the appropriate class, and is
	 *  not one that has been previously removed. Note that our current
	 *  implementation does not actually verify that the node belongs
	 *  to this particular list instance.
	 *  @param p    a node (that should belong to this tree)
	 *  @return the underlying Node instance for the node
	 *  @throws IllegalArgumentException if an invalid node is detected */
	private BinaryNode<T> validate(Node<T> n) throws IllegalArgumentException {
		if (!(n instanceof BinaryNode)) {
			throw new IllegalArgumentException("Not valid node type");
		}
		BinaryNode<T> node = (BinaryNode<T>) n;       // safe cast
		if (node.getParent() == node) {       // our convention for defunct node
			throw new IllegalArgumentException("This node is no longer in the tree");
		}
		return node;
	}

	/* accessor methods (not already implemented in AbstractBinaryTree) */
	/** method size
	 *  returns the number of nodes in the tree
	 *  @return number of nodes in the tree */
	@Override
	public int size() {
		return size;
	}

	/** method root
	 *  returns the root Node of the tree or null if tree is empty
	 *  @return root Node of the tree or null if tree is empty */
	@Override
	public Node<T> root() {
		return root;
	}

	/** method parent
	 *  returns the node of n's parent or null if n is root
	 *  @param n    a valid Node within the tree
	 *  @return node of n's parent or null if n is root
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	@Override
	public Node<T> parent(Node<T> n) throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		return node.getParent();
	}

	/** method: left
	 *  returns the node of n's left child or null if no child exists
	 *  @param n    a valid node within the tree
	 *  @return the node of the left child or null if no child exists
	 *  @throws IllegalArgumentException if n is not a valid Node for this tree */
	@Override
	public Node<T> left(Node<T> n) throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		return node.getLeft();
	}

	/** method right
	 *  returns the node of n's right child or null if no child exists
	 *  @param n    a valid Node within the tree
	 *  @return the node of the right child or null if no child exists
	 *  @throws IllegalArgumentException if n is not a valid Node for this tree */
	@Override
	public Node<T> right(Node<T> n) throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		return node.getRight();
	}

	/* update methods supported by this class */
	/** method addRoot
	 *  places element e at the root of an empty tree and returns its new node
	 *  @param e    the new element
	 *  @return the node of the new element
	 *  @throws IllegalStateException if the tree is not empty */
	public Node<T> addRoot(T e) throws IllegalStateException {
		if (!isEmpty()) { throw new IllegalStateException("Tree is not empty"); }
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/** method addLeft
	 *  creates a new left child of node n storing element e and returns it
	 *  @param n    the node to the left of which the new element is inserted
	 *  @param e    the new element
	 *  @return the node of the new element
	 *  @throws IllegalArgumentException if n is not a valid node for this tree
	 *  @throws IllegalArgumentException if n already has a left child */
	public Node<T> addLeft(Node<T> n, T e) throws IllegalArgumentException {
		BinaryNode<T> parent = validate(n);
		if (parent.getLeft() != null) {
			throw new IllegalArgumentException("This node already has a left child");
		}
		BinaryNode<T> child = createNode(e, parent, null, null);
		parent.setLeft(child);
		size++;
		return child;
	}

	/** method addRight
	 *  creates a new right child of Position p storing element e and returns it
	 *  @param n    the node to the right of which the new element is inserted
	 *  @param e    the new element
	 *  @return the node of the new element
	 *  @throws IllegalArgumentException if n is not a valid node for this tree
	 *  @throws IllegalArgumentException if n already has a right child */
	public Node<T> addRight(Node<T> n, T e) throws IllegalArgumentException {
		BinaryNode<T> parent = validate(n);
		if (parent.getRight() != null) {
			throw new IllegalArgumentException("This node already has a right child");
		}
		BinaryNode<T> child = createNode(e, parent, null, null);
		parent.setRight(child);
		size++;
		return child;
	}

	/** method set
	 *  replaces the element at node n with element e and returns the replaced element
	 *  @param n    the relevant node
	 *  @param e    the new element
	 *  @return the replaced element
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	public T set(Node<T> n, T e) throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		T temp = node.getElement();
		node.setElement(e);
		return temp;
	}

	/** method attach
	 *  attaches trees t1 and t2, respectively, as the left and right subtree of the
	 *  leaf node n. As a side effect, t1 and t2 are set to empty trees
	 *  @param n    a leaf of the tree
	 *  @param t1    an independent tree whose structure becomes the left child of n
	 *  @param t2	  an independent tree whose structure becomes the right child of n
	 *  @throws IllegalArgumentException if n is not a valid Position for this tree
	 *  @throws IllegalArgumentException if n is not a leaf */
	public void attach(Node<T> n, LinkedBinaryTree<T> t1, LinkedBinaryTree<T> t2) 
			throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		if (isInternal(n)) { throw new IllegalArgumentException("This node must be a leaf"); }
		size += t1.size() + t2.size();
		if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
			t2.root.setParent(node);
			node.setRight(t2.root);
			t2.root = null;
			t2.size = 0;
		}
	}

	/** method remove
	 *  removes the node at node n and replaces it with its child, if any
	 *  @param n    the node to be removed
	 *  @return element that was removed
	 *  @throws IllegalArgumentException if n is not a valid node for this tree.
	 *  @throws IllegalArgumentException if n has two children */
	public T remove(Node<T> n) throws IllegalArgumentException {
		BinaryNode<T> node = validate(n);
		if (numChildren(n) == 2) {
			throw new IllegalArgumentException("This node has two children");
		}
		BinaryNode<T> child = ((node.getLeft() != null) ? node.getLeft() : node.getRight());
		if (child != null) {
			child.setParent(node.getParent());  // child's grandparent becomes its parent
		}
		if (node == root) {
			root = child;                       // child becomes root
		} else {
			BinaryNode<T> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRight(child);
			}
		}
		size--;
		T temp = node.getElement();
		node.setElement(null);                // help garbage collection
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);                 // our convention for defunct node
		return temp;
	}

	/** method: toString
	 *  produces a string representation of the contents of the indexed list
	 *  @return textual representation of the binary tree */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		for (Node<T> node: breadthfirst()) {
			if (node != root()) { sb.append(", "); }
			sb.append(node.getElement());
		}
		sb.append(")");
		return sb.toString();
	}

}
