package org.light4j.dataStructure.linearList.linkList.circular;

import org.light4j.dataStructure.linearList.linkList.Node;
import org.light4j.dataStructure.linearList.linkList.head.HeadSinglyLinkedList;

/**
 * <p>
 * 循环单链表类,基本操作和带头结点的单链表类似, 只是在尾添加和尾移除元素的时候需要更改尾结点的next域指向head
 * </p>
 * 
 * @author longjiazuo
 * 
 * @param <E>
 */
public class CircularSinglyLinkedList<E> extends HeadSinglyLinkedList<E> {
	/**
	 * 构造空单链表
	 */
	public CircularSinglyLinkedList() {
		this.head = new Node<E>(null);
		this.rear = this.head;
		this.head.next = this.head;
		this.n = 0;
	}

	/**
	 * 在指定位置插入非空的指针对象
	 */
	@Override
	public boolean add(int index, E element) {
		if (element == null) {// 不允许插入非空元素
			return false;
		}
		if (index >= this.n) {// 尾插入,插入在最后
			this.add(element);
		} else {
			Node<E> p = this.head;
			int i = 0;
			while (p.next != null && i < index) {
				i++;
				p = p.next;
			}
			// 下面操作可以包含头插入和中间插入
			Node<E> q = new Node<E>(element);
			q.next = p.next;
			p.next = q;// 将q结点插入到p结点之后
			this.n++;
			return true;
		}
		return false;
	}

	/**
	 * 在单链表的最后插入元素对象,时间复杂度是O(1)
	 */
	@Override
	public boolean add(E element) {
		if (element == null) {// 不允许插入非空元素
			return false;
		}
		this.rear.next = new Node<E>(element);// 尾插入
		this.rear = this.rear.next;// 移动尾指针
		this.rear.next = this.head;//把尾结点的next域指向head结点
		this.n++;// 链表长度增加
		return true;
	}

	/**
	 * 移除索引index处的结点,操作成功返回被移除的对象,失败则返回null
	 */
	@Override
	public E remove(int index) {
		E old = null;
		if (index >= 0) {// 头删除,中间删除,尾删除
			Node<E> p = this.head;
			int i = 0;
			while (p.next != null && i < index) {// 从头结点开始遍历,定位到待删除结点的前驱结点
				i++;
				p = p.next;
			}
			if (p.next != null) {
				old = p.next.data;
				if (p.next == this.rear) {// 如果p结点的后一个结点是尾结点,则移除之后尾结点指针前移
					this.rear = p;
					this.rear.next = this.head;
				}
				p.next = p.next.next;// 删除p结点的后继结点
				this.n--;// 链表长度减少
				return old;
			}
		}
		return old;
	}

	@Override
	public void clear() {
		this.head.next = this.head;
		this.n = 0;
	}
	
	@Override
	public String toString() {// 返回所有元素值对应的字符串
		String str = "(";
		Node<E> p = this.head.next;
		while (p.data != null) {
			str += p.data.toString();
			p = p.next;
			if (p != null) {
				str += ", ";
			}
		}
		return str + ")";
	}
}