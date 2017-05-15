package org.light4j.dataStructure.sample.linearList.linkList;

/**
 * 链表节点类
 * 
 * @author longjiazuo
 */
public class Node<E> {
	public E data;// 链表数据域,保存数据元素
	public Node<E> next;// 链表地址域,引用后继节点

	public Node(E data, Node<E> next) {// 构造节点,指定数据元素和后继节点
		this.data = data;
		this.next = next;
	}

	public Node(E data) {
		this(data, null);
	}

	public Node() {
		this(null, null);
	}
}