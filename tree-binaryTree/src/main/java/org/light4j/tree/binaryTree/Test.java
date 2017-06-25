package org.light4j.tree.binaryTree;

public class Test {
	public static void main(String[] args) {
		// D结点
		BinaryNode<String> node_d = new BinaryNode<String>("D", null,
				new BinaryNode<String>("G"));
		// B结点
		BinaryNode<String> node_b = new BinaryNode<String>("B", node_d, null);

		// F结点
		BinaryNode<String> node_f = new BinaryNode<String>("F",
				new BinaryNode<String>("H"), null);
		// C结点
		BinaryNode<String> node_c = new BinaryNode<String>("C",
				new BinaryNode<String>("E"), node_f);

		// A结点
		BinaryNode<String> node_a = new BinaryNode<String>("A", node_b, node_c);
		// 创建二叉树
		BinaryTree<String> binaryTree = new BinaryTree<>(node_a);
		// 先根遍历
		binaryTree.preOrder();
		// 中根遍历
		binaryTree.inOrder();
		// 后根遍历
		binaryTree.postOrder();
		// 二叉树结点个数
		System.out.println("\n 结点个数：" + binaryTree.count());
		// 二叉树的高度
		System.out.println("\n 树的高度：" + binaryTree.height());
	}
}