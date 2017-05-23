package org.light4j.dataStructure.linearList.linkList.doubleLink;

/**
 * 双链表结点类
 * 
 * @author longjiazuo
 */
public class DoubleLinkNode<E> {
	public E data;// 数据元素
	public DoubleLinkNode<E> prev;// 前驱结点
	public DoubleLinkNode<E> next;// 后继结点

	/**
	 * 指定数据元素,前驱结点和后继结点的构造函数
	 * 
	 * @param data
	 * @param prev
	 * @param next
	 */
	public DoubleLinkNode(E data, DoubleLinkNode<E> prev, DoubleLinkNode<E> next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * 指定数据元素的构造函数
	 * 
	 * @param data
	 */
	public DoubleLinkNode(E data) {
		this(data, null, null);
	}

	/**
	 * 默认构造函数
	 */
	public DoubleLinkNode() {
	}
}