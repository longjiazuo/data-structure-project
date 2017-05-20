package org.light4j.dataStructure.linearList.linkList.reverse;

import org.light4j.dataStructure.linearList.linkList.Node;
import org.light4j.dataStructure.linearList.linkList.SinglyLinkedList;

/**
 * 可逆转的单链表,继承自SinglyLinkedList
 * 
 * @author longjiazuo
 */
public class ReverseSinglyLinkedList<E> extends SinglyLinkedList<E> {
	public ReverseSinglyLinkedList() {
		super();// 调用父类同参数的构造方法
	}

	/**
	 * 实现单链表逆转的方法
	 */
	public void reverse() {
		Node<E> p = this.head;
		Node<E> front = null;
		Node<E> q = null;
		while (p != null) {
			q = p.next;// 设置q结点是p的后继结点
			p.next = front;// 使p的后继结点指向其前驱节点
			front = p;// front结点向后移动
			p = q;// p结点向后移动
		}
		this.head = front;// 头结点指向front
	}
}