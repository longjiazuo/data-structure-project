package org.light4j.dataStructure.sample.linkList.reverse;

import org.light4j.dataStructure.sample.linkList.Node;
import org.light4j.dataStructure.sample.linkList.SinglyLinkedList;

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

	/**
	 * 主方法测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseSinglyLinkedList<Integer> rslk = new ReverseSinglyLinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			rslk.add(0, new Integer(i));
		}
		System.out.println("单链表: " + rslk.toString());
		rslk.reverse();
		System.out.println("逆转后的单链表: " + rslk.toString());
	}
}