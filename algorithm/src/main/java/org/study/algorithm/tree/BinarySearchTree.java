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
			return null;
		}

		// 判断x是否小于节点的左叶子节点，如果小于，则左叶子节点成为父节点，x设置为其左叶子节点
		if (null == t.left || x.compareTo(t.left.element) <= 0) {
			BinaryNode<AnyType> newNode = new BinaryNode<>(x);
			if (null == t.left) {
				t.left = newNode;
			}

			t.left.left = newNode;
		}
		// 如果x介于左叶子节点与父节点之间，则设置x为当前节点的左节点，原左叶子节点下沉成为x的左节点
		else if (x.compareTo(t.left.element) > 0 && x.compareTo(t.element) <= 0) {
			BinaryNode<AnyType> newNode = new BinaryNode<>(x);
			newNode.left = t.left;
			t.left = newNode;
		}
		// 如果x小于当前父节点的左节点，则继续找
		else if (x.compareTo(t.left.element) < 0) {
			insert(x, t.left);
		}
		// 如果x介于父节点与右节点之间，则设置x为父节点，原父节点成为左节点
		else if (null == t.right || x.compareTo(t.element) > 0) {
			BinaryNode<AnyType> newNode = new BinaryNode<>(x);
			newNode.left = t;
			newNode.right = t.right;
			t = newNode;
		}
		// 如果x大于右节点
		else if (x.compareTo(t.right.element) > 0) {
			insert(x, t.right);
		}
		
		return t;
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		return null;
	}

	private void printTree(BinaryNode<AnyType> t) {
		if (null == t) {
			System.out.println("Tree is null");
		}
		BinaryNode<AnyType> currentNode = t;
		int high = 1;
		while (null != currentNode.left) {
			System.out.println("第" + high + "层" + currentNode.element + " leftTree:" + currentNode.left.element);
			currentNode = currentNode.left;
		}
		while (null != currentNode.right) {
			System.out.println("第" + high + "层" + currentNode.element + " rightTree:" + currentNode.right.element);
			currentNode = currentNode.right;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		BinaryNode<Integer> root = new BinaryNode<Integer>(12);
		tree.root = root;
		for(int i=10;i<13;i++) {
			tree.insert(i);
		}
		tree.printTree();
	}
}
