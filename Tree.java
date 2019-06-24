import java.util.Iterator;


/** Tree interface
 *  provides methods operated on Tree ADT.
 *  Tree ADT is a nonlinear data structure that simulates a 
 *  hierarchical tree structure, with a root value and subtrees of children with a parent node, 
 *  represented as a set of linked nodes. */

public interface Tree<T> extends Iterable<T> {

	/** method size
	 *  returns the number of nodes in the tree
	 *  @return number of nodes in the tree */
	int size();

	/** method isEmpty
	 *  tests whether the tree is empty
	 *  @return true if the tree is empty, false otherwise */
	boolean isEmpty();

	/** method root
	 *  returns the root Node of the tree or null if tree is empty
	 *  @return root Node of the tree or null if tree is empty */
	Node<T> root();

	/** method parent
	 *  returns the node of n's parent or null if n is root
	 *  @param n    a valid Node within the tree
	 *  @return node of n's parent or null if n is root
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	Node<T> parent(Node<T> n) throws IllegalArgumentException;

	/** method children
	 *  returns an iterable collection of the n's child nodes
	 *  @param n    a valid node within the tree
	 *  @return iterable collection of the n's child nodes
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	Iterable<Node<T>> children(Node<T> n) throws IllegalArgumentException;

	/** method numChildren
	 *  returns the number of children of node n
	 *  @param n    a valid Node within the tree
	 *  @return number of children of node n
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	int numChildren(Node<T> n) throws IllegalArgumentException;

	/** method isInternal
	 *  returns true if node n has one or more children
	 *  @param n    a valid node within the tree
	 *  @return true if n has at least one child, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	boolean isInternal(Node<T> p) throws IllegalArgumentException;

	/** method isExternal
	 *  returns true if node n does not have any children
	 *  @param n    a valid Node within the tree
	 *  @return true if n has zero children, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	boolean isExternal(Node<T> n) throws IllegalArgumentException;

	/** method isRoot
	 *  returns true if node n is the root of the tree
	 *  @param n    a valid node within the tree
	 *  @return true if n is the root of the tree, false otherwise
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	boolean isRoot(Node<T> n) throws IllegalArgumentException;

	/** method nodes
	 *  returns an iterable collection of the nodes of the tree
	 *  @return iterable collection of the tree's nodes */
	Iterable<Node<T>> nodes();

	/** method iterator
	 *  returns an iterator of the elements stored in the tree
	 *  @return iterator of the tree's elements */
	Iterator<T> iterator();
}