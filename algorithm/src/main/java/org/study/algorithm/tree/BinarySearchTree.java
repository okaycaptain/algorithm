/**
 * 
 */
package org.study.algorithm.tree;

/**
 * @author captain
 *
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	// 数据结构
	private static class BinaryNode<AnyType> {
		public BinaryNode(AnyType theElement) {
			this(theElement, null, null);
		}

		public BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
			this.element = theElement;
			this.left = lt;
			this.right = rt;
		}

		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
	}

	private BinaryNode<AnyType> root;

	public BinarySearchTree() {
		root = null;
	}

	public void mackEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return null == root;
	}

	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	public AnyType findMin() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMin(root).element;
	}

	public AnyType findMax() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMax(root).element;
	}

	public void insert(AnyType x) {
		insert(x, root);
	}

	public void remove(AnyType x) {

	}

	public void printTree() {
		if(isEmpty()) {
			System.out.println("Empty tree");
		}
		printTree(root);
	}

	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (null == t) {
			return false;
		}

		int compareResult = x.compareTo(t.element);
		if (compareResult < 0) {
			return contains(x, t.left);
		} else if (compareResult > 0) {
			return contains(x, t.right);
		} else {
			return true;
		}
	}

	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (null == t) {
			return null;
		}

		BinaryNode<AnyType> tempLeftNode = root.left;
		while (null != tempLeftNode.left) {
			tempLeftNode = tempLeftNode.left;
		}

		return tempLeftNode.left;
	}

	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (null == t) {
			return null;
		}

		BinaryNode<AnyType> tempRightNode = root.right;
		while (null != tempRightNode.right) {
			tempRightNode = tempRightNode.right;
		}

		return tempRightNode.right;
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (null == t) {
			return new BinaryNode<>(x, null, null);
		}

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			t.left = insert(x, t.left);
		} else if (compareResult > 0) {
			t.right = insert(x, t.right);
		} else {
			; // 重复值，暂不处理
		}

		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		return null;
	}

	private void printTree(BinaryNode<AnyType> t) {
		if(null != t) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		BinaryNode<Integer> root = new BinaryNode<Integer>(12);
		tree.root = root;
		for (int i = 3; i < 17; i=i+i/2) {
			tree.insert(i);
		}
		tree.printTree();
	}
}
