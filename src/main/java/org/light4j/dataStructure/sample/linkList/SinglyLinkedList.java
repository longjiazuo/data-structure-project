package org.light4j.dataStructure.sample.linkList;

import org.light4j.dataStructure.sample.linearList.LList;

public class SinglyLinkedList<E> implements LList<E> {
	protected Node<E> head;// 单链表头结点,指向单链表第一个结点

	/**
	 * 构造空单链表
	 */
	public SinglyLinkedList() {
		this.head = null;
	}

	/**
	 * 构造指定头结点的单链表
	 * 
	 * @param head
	 */
	public SinglyLinkedList(Node<E> head) {
		this.head = head;
	}

	/**
	 * 判断单链表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	/**
	 * 遍历单链表返回单链表长度
	 */
	@Override
	public int length() {
		Node<E> p = this.head;// p从head指向的节点开始
		int i = 0;
		while (p != null) {// 若单链表未结束
			i++;
			p = p.next;// p到达后继节点
		}
		return i;
	}

	/**
	 * 返回序号为index的的对象,如果链表为空或者序号错误则返回null
	 */
	@Override
	public E get(int index) {
		Node<E> p = this.head;
		int i = 0;
		while (p != null && i < index) {
			i++;
			p = p.next;
		}
		if (p != null) {
			return p.data;
		}
		return null;
	}

	/**
	 * 设置序号为index的对象的值为element,如果操作成功则返回原对象,操作失败返回null
	 */
	@Override
	public E set(int index, E element) {
		if (this.head != null && index >= 0 && element != null) {
			Node<E> p = this.head;
			int i = 0;
			while (p != null && i < index) {
				i++;
				p = p.next;
			}
			if (p != null) {
				E old = p.data;
				p.data = element;
				return old;// 操作成功返回原对象
			}
		}
		return null;// 操作失败则返回null
	}

	/**
	 * 插入elment元素,插入后对象序号为index,如果操作成功则返回true
	 */
	@Override
	public boolean add(int index, E element) {
		if (element == null) {
			return false;
		}
		Node<E> q = new Node<E>(element);// 创建要插入的结点
		if (this.head == null || index <= 0) {// 在头结点后面插入
			q.next = this.head;
			this.head = q;
		} else {// 中间或者尾结点后面插入
			Node<E> p = this.head;
			int i = 0;
			while (p.next != null && i < index - 1) {// 寻找插入位置
				i++;
				p = p.next;
			}
			q.next = p.next;// q插入在p结点之后
			p.next = q;
		}

		return true;
	}

	/**
	 * 在单链表最后插入对象
	 */
	@Override
	public boolean add(E element) {
		return add(Integer.MAX_VALUE, element);
	}

	/**
	 * 移除序号为index的对象,如果操作成功则返回被移除的对象,操作失败则返回null
	 */
	@Override
	public E remove(int index) {
		E old = null;
		if (this.head != null && index >= 0) {
			if (index == 0) {// 头删除
				old = this.head.data;
				this.head = this.head.next;
				return old;
			} else {// 中间删除或者尾删除
				Node<E> p = this.head;
				int i = 0;
				while (p != null && i < index - 1) {// 定位到待删除节点的前驱节点
					i++;
					p = p.next;
				}
				if (p != null && p.next != null) {
					old = p.next.data;// 操作成功返回被移去对象
					p.next = (p.next).next;// 删除p的后继节点
				}
			}
		}
		return old;
	}

	@Override
	public void clear() {// 清空单链表
		this.head = null;
	}

	@Override
	public String toString() {// 返回所有元素值对应的字符串
		String str = "(";
		Node<E> p = this.head;
		while (p != null) {
			str += p.data.toString();
			p = p.next;
			if (p != null) {
				str += ", ";
			}
		}
		return str + ")";
	}
}