package org.light4j.tree.binaryTree;

import lombok.Data;

/**
 * 二叉链表结点类
 * 
 * @author longjiazuo
 * 
 * @param <E>
 */
@Data
public class BinaryNode<E> {
	// 数据元素
	private E data;
	// 左孩子结点
	private BinaryNode<E> left;
	// 右孩子结点
	private BinaryNode<E> right;

	// 指定数据元素，左右孩子结点的构造函数
	public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// 指定数据元素的构造函数
	public BinaryNode(E data) {
		this(data, null, null);
	}

	// 空构造函数
	public BinaryNode() {
		this(null, null, null);
	}
}