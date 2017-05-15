package org.light4j.dataStructure.sample.linearList.linkList.doubleLink;

/**
 * 带头结点的循环双链表类
 * 
 * @author longjiazuo
 */
public class CycleHeadDoubleLinkedList<E> {
	protected DoubleLinkNode<E> head;

	public CycleHeadDoubleLinkedList() {
		this.head = new DoubleLinkNode<E>(null);// 头指针
		this.head.prev = this.head;
		this.head.next = this.head;
	}
}
