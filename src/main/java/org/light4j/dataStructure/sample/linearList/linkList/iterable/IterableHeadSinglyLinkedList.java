package org.light4j.dataStructure.sample.linearList.linkList.iterable;

import java.util.Iterator;

import org.light4j.dataStructure.sample.linearList.AbstractList;
import org.light4j.dataStructure.sample.linearList.LList;
import org.light4j.dataStructure.sample.linearList.linkList.Node;
/**
 * 可迭代的带头结点的单链表类
 * 
 * @author longjiazuo
 */
public class IterableHeadSinglyLinkedList<E> extends AbstractList<E> implements LList<E> {
	protected Node<E> head;// 单链表的头结点,指向单链表的头结点
	protected Node<E> rear;// 单链表的尾结点,指向单链表的最后一个结点
	protected int n;// 单链表的长度

	public IterableHeadSinglyLinkedList() {// 构造空单链表
		this.head = new Node<E>(null);// 构造头结点,元素值为空
		this.rear = this.head;// 构造尾结点,初始化的时候头结点和尾结点都指向头结点
		this.n = 0;// 初始化链表长度为0
	}

	/**
	 * 判断带头结点的单链表是否为空
	 */
	@Override
	public boolean isEmpty() {
		return this.head.next == null;
	}

	/**
	 * 返回带头结点的单链表长度,时间复杂度为O(1)
	 */
	@Override
	public int length() {
		return this.n;
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
				}
				p.next = p.next.next;// 删除p结点的后继结点
				this.n--;// 链表长度减少
				return old;
			}
		}
		return old;
	}

	/**
	 * 清空单链表
	 */
	@Override
	public void clear() {
		this.head.next = null;
		this.rear = this.head;
		this.n = 0;
	}

	/**
	 * 返回迭代器对象
	 */
	@Override
	public Iterator<E> iterator() {
		return new HeadSinglyLinkedListIterator<E>();
	}

	/**
	 * 实现迭代器接口
	 * 
	 * @author longjiazuo
	 */
	@SuppressWarnings("hiding")
	private class HeadSinglyLinkedListIterator<E> implements Iterator<E> {
		@SuppressWarnings("unchecked")
		private Node<E> cursor = (Node<E>) head;// 初始的时候指向头结点

		/**
		 * 判断是否有后继元素
		 */
		@Override
		public boolean hasNext() {
			return cursor != null && cursor.next != null;
		}

		/**
		 * 返回后继元素
		 */
		@Override
		public E next() {
			if (cursor != null && cursor.next != null) {
				E element = cursor.next.data;
				cursor = cursor.next;
				return element;
			}
			return null;
		}

		/**
		 * 移除元素
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();// 不支持该操作,抛出异常
		}
	}
	
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IterableHeadSinglyLinkedList<String> list = new IterableHeadSinglyLinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}