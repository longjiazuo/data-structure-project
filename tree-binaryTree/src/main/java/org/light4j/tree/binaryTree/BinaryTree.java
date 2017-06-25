package org.light4j.tree.binaryTree;

/**
 * 二叉树类
 * 
 * @author longjiazuo
 * 
 * @param <E>
 */
public class BinaryTree<E> {
	// 根结点
	protected BinaryNode<E> root;

	/**
	 * 构造空二叉树
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * 构造指定结点的二叉树
	 * 
	 * @param root
	 */
	public BinaryTree(BinaryNode<E> root) {
		this.root = root;
	}

	/**
	 * 判断二叉树是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.root == null;
	}

	/**
	 * 返回二叉树的根节点
	 * 
	 * @return
	 */
	public BinaryNode<E> getRoot() {
		return this.root;
	}

	/**
	 * 返回node结点的父母结点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryNode<E> getParent(BinaryNode<E> node) {
		return null;
	}

	/**
	 * 先根遍历,从根结点root开始
	 */
	public void preOrder() {
		System.out.println("\n 先根序列：");
		this.preOrder(root);
	}

	/**
	 * 先根遍历,从指定节点开始
	 */
	public void preOrder(BinaryNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	/**
	 * 中根遍历,从根结点root开始
	 */
	public void inOrder() {
		System.out.println("\n 中根序列：");
		this.inOrder(root);
	}

	/**
	 * 中根遍历,从指定节点开始
	 */
	public void inOrder(BinaryNode<E> node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getData() + " ");
			inOrder(node.getRight());
		}
	}

	/**
	 * 后根遍历,从根结点root开始
	 */
	public void postOrder() {
		System.out.println("\n 后根序列：");
		this.postOrder(root);
	}

	/**
	 * 后根遍历,从指定节点开始
	 */
	public void postOrder(BinaryNode<E> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}

	/**
	 * 按层次遍历二叉树
	 */
	public void levelOrder() {

	}

	/**
	 * 求二叉树结点个数
	 * 
	 * @return
	 */
	public int count() {
		return this.count(this.root);
	}

	/**
	 * 求从指定节点开始遍历的结点个数
	 * 
	 * @param node
	 * @return
	 */
	private int count(BinaryNode<E> node) {
		if (node != null) {
			return 1 + count(node.getLeft()) + count(node.getRight());
		}
		return 0;
	}

	/**
	 * 求树的高度
	 * 
	 * @return
	 */
	public int height() {
		return this.height(root);
	}

	/**
	 * 求node子树的高度
	 * 
	 * @param node
	 * @return
	 */
	private int height(BinaryNode<E> node) {
		if (node != null) {
			int ld = height(node.getLeft());// 返回左子树的高度
			int rd = height(node.getRight());// 返回右子树的高度
			return ld >= rd ? (ld + 1) : (rd + 1);// 当前子树高度为较高子树的高度加1
		}
		return 0;
	}

	/**
	 * 查找并返回元素为element的结点,从根结点开始查找
	 * 
	 * @param element
	 * @return
	 */
	public BinaryNode<E> search(E element) {
		return search(root, element);
	}

	/**
	 * 查找并返回元素为element的结点,从指定结点开始查找
	 * 
	 * @param p
	 * @param element
	 * @return
	 */
	public BinaryNode<E> search(BinaryNode<E> node, E element) {
		return null;
	}

	/**
	 * 插入element元素作为node结点的左/右孩子结点
	 * 
	 * @param node
	 * @param data
	 * @param leftChild
	 */
	public void insert(BinaryNode<E> node, E data, boolean leftChild) {

	}

	/**
	 * 删除p结点的左/右子树
	 * 
	 * @param node
	 * @param leftChild
	 */
	public void remove(BinaryNode<E> node, boolean leftChild) {
	}

	/**
	 * 清空二叉树
	 */
	public void clear() {
		this.root = null;
	}
}