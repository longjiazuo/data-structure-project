package org.light4j.dataStructure.linearList.linkList.doubleLink;

import org.light4j.dataStructure.linearList.LList;

/**
 * 双链表类
 * 
 * @author longjiazuo
 */
public class DoubleLinkedList<E> implements LList<E> {
	protected DoubleLinkNode<E> head;// 双链表的头结点
	protected int n;// 双链表的长度

	public DoubleLinkedList() {// 构造空双链表
		this.head = new DoubleLinkNode<E>(null, null, null);// 头指针
		this.n = 0;
	}

	/**
	 * 判断双链表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.head.next == null;
	}

	/**
	 * 返回双链表长度,时间复杂度为O(1)
	 */
	@Override
	public int length() {
		return n;
	}

	/**
	 * 返回序号为index的的对象,如果链表为空或者序号错误则返回null
	 */
	@Override
	public E get(int index) {
		DoubleLinkNode<E> p = this.head;
		int i = 0;
		while (p != null && i < index) {// 遍历双链表
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
		if (index <= this.n && element != null) {
			DoubleLinkNode<E> p = this.head;
			int i = 0;
			while (p != null && i < index) {
				i++;
				p = p.next;
			}
			if (p != null) {
				E old = p.data;
				p.data = element;
				return old;
			}
		}
		return null;
	}

	/**
	 * 在指定位置插入非空的结点
	 */
	@Override
	public boolean add(int index, E element) {
		if (index < 0 || element == null) {// 如果插入序号不正确或者元素为空返回false
			return false;
		}
		if (index > this.n) {// 尾插入,把元素插入到最后面
			this.add(element);
		} else {
			DoubleLinkNode<E> p = this.head;// p指向头结点
			int i = 0;
			while (p != null && i < index) {// 遍历双链表
				i++;
				p = p.next;
			}
			if (p != null) {
				DoubleLinkNode<E> q = new DoubleLinkNode<E>(element);// 新建q结点
				q.prev = p.prev;
				q.next = p;
				p.prev.next = q;
				p.prev = q;
				this.n++;// 链表长度加1
			}
		}
		return true;
	}

	/**
	 * 在双链表的最后插入元素对象
	 */
	@Override
	public boolean add(E element) {
		if (element == null) {// 不允许插入空元素
			return false;
		}
		DoubleLinkNode<E> p = this.head;
		while (p.next != null) {// 循环双链表
			p = p.next;
		}
		DoubleLinkNode<E> q = new DoubleLinkNode<E>(element);// 创建要插入的结点q
		p.next = q;
		q.prev = p;
		this.n++;// 链表长度加1
		return true;
	}

	/**
	 * 移除索引index处的结点,操作成功返回被移除的对象,失败则返回null
	 */
	@Override
	public E remove(int index) {
		E old = null;
		if (index >= 0) {// 要删除元素的索引不能小于0
			if (index == 0) {// 等于0是头结点,不能移除头指针,如果值是0,赋值为1
				index = 1;
			}
			DoubleLinkNode<E> p = this.head;// p结点指向头结点
			int i = 0;
			while (p != null && i < index) {// 遍历寻找元素
				i++;
				p = p.next;
			}
			if (p != null) {
				old = p.data;
				p.prev.next = p.next;
				if (p.next != null) {
					p.next.prev = p.prev;
				}
				this.n--;// 双链表长度减1
			}
		}
		return old;
	}

	/**
	 * 清空双链表
	 */
	@Override
	public void clear() {
		this.head.next = null;
		this.n = 0;
	}

	@Override
	public String toString() {// 返回所有元素值对应的字符串
		String str = "(";
		DoubleLinkNode<E> p = this.head.next;
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