

/** BinaryTree interface
 *  provide methods operated on binary tree ADT. 
 *  The binary tree ADT is an special tree in which each node has at most two children. 
 *  A proper binary tree s a tree in which every node has either 0 or 2 children. 
 *  A complete binary tree, is a tree in every level, except possibly the last, is completely filled, 
 *  and all nodes in the last level are as far left as possible.
 *  A perfect binary tree is a binary tree in which all interior nodes have two children 
 *  and all leaves have the same depth or same level
 *  A balanced binary tree is a binary tree structure 
 *  in which the left and right subtrees of every node differ in height by no more than 1 */

public interface BinaryTree<T> extends Tree<T> {

	/** method left
	 *  returns the node of n's left child or null if no child exists
	 *  @param n    a valid node within the tree
	 *  @return the node of the left child or null if no child exists
	 *  @throws IllegalArgumentException if n is not a valid Node for this tree */
	Node<T> left(Node<T> n) throws IllegalArgumentException;

	/** method right
	 *  returns the node of n's right child or null if no child exists
	 *  @param n    a valid Node within the tree
	 *  @return the Node of the right child or null if no child exists
	 *  @throws IllegalArgumentException if n is not a valid Node for this tree */
	Node<T> right(Node<T> n) throws IllegalArgumentException;

	/** method sibling 
	 *  returns the node of n's sibling or null if no sibling exists
	 *  @param n    a valid node within the tree
	 *  @return the node of the sibling or null if no sibling exists
	 *  @throws IllegalArgumentException if n is not a valid node for this tree */
	Node<T> sibling(Node<T> n) throws IllegalArgumentException;
}
