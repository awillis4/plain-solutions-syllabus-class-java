
/** Driver class to test binary tree */

public class TestBinaryTree {

	public static void main(String args[]) {
		LinkedBinaryTree<Integer> lbt = new LinkedBinaryTree<>();
		// test size method
		System.out.println(lbt.size());
		// test isEmpty method
		System.out.println(lbt.isEmpty());
		// test root method
		System.out.println(lbt.root());
		// test addRoot method 
		Node<Integer> root = lbt.addRoot(100);
		// test addLeft method
		Node<Integer> leftChild = lbt.addLeft(root, 200);
		// test addRight method
		Node<Integer> rightChild = lbt.addRight(root, 300);
		// display the binary tree in BFS order
		System.out.println(lbt.toString());
		// test left, right methods
		System.out.println("root's left child is" + lbt.left(root).getElement()); 
		System.out.println("root's right child is" + lbt.right(root).getElement()); 
		// display size
		System.out.println("size: " + lbt.size());
		System.out.println("number of children: " + lbt.numChildren(root));
		// display children of the root (left then right)
		for (Node<Integer> c : lbt.children(root)) {
			System.out.println("child: " + c.getElement());
		}
		// display all the nodes in the binary tree (inorder)
		for (Node<Integer> n : lbt.nodes()) {
			System.out.println("node: " + n.getElement());
		}		 
		// add two children to the left child of the root
		Node<Integer> leftChild1 = lbt.addLeft(leftChild, 400);
		Node<Integer> rightChild1 = lbt.addRight(leftChild, 500);
		// add two children to the right child of the root
		Node<Integer> leftChild2 = lbt.addLeft(rightChild, 600);
		Node<Integer> rightChild2 = lbt.addRight(rightChild, 700);
		// display the binary tree (BFS)
		System.out.println(lbt.toString());
		// test isRoot, isInternal, isExternal
		System.out.println(lbt.isExternal(root));
		System.out.println(lbt.isInternal(root));
		System.out.println(lbt.isRoot(root));
		System.out.println(lbt.isExternal(leftChild));
		System.out.println(lbt.isInternal(leftChild));
		System.out.println(lbt.isRoot(leftChild));	
		System.out.println(lbt.isExternal(leftChild1));
		System.out.println(lbt.isInternal(leftChild1));
		System.out.println(lbt.isRoot(leftChild1));
		// test depth and height
		System.out.println(lbt.height(root));
		System.out.println(lbt.depth(leftChild));
		System.out.println(lbt.depth(leftChild1));
		// test set
		int element = lbt.set(root, 1000);
		System.out.println(lbt.toString());
		// test remove
		// element = lbt.remove(root); 
		// can't remove the root since it has two child nodes
		element = lbt.remove(leftChild1);
		System.out.println(lbt.toString());
 
		LinkedBinaryTree<Integer> lbt1 = new LinkedBinaryTree<>();	
		LinkedBinaryTree<Integer> lbt2 = new LinkedBinaryTree<>();
		lbt1.addRoot(10);
		lbt2.addRoot(20);
		lbt.attach(rightChild2, lbt1, lbt2);
		System.out.println(lbt.toString());
	}
}
