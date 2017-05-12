package org.light4j.dataStructure.sample.linkList.head.sorted;

import org.light4j.dataStructure.sample.linkList.Node;
import org.light4j.dataStructure.sample.linkList.head.HeadSinglyLinkedList;

/**
 * 排序的单链表
 * 
 * @author longjiazuo
 */
public class SortedHeadSinglyLinkedList<E> extends HeadSinglyLinkedList<E> {
	public SortedHeadSinglyLinkedList() {
		super();
	}

	/**
	 * 根据指定对象的大小把对象插入到合适的位置上,操作成功返回true
	 */
	@Override
	public boolean add(E element) {
		// 不能插入null或者非Comparable对象
		if (element == null || !(element instanceof Comparable)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Comparable<E> cmp = (Comparable<E>) element;
		Node<E> front = this.head;
		Node<E> p = front.next;// front结点是p的前驱结点
		while (p != null && (cmp.compareTo(p.data) > 0)) {// 比较对象大小
			front = p;
			p = p.next;
		}
		front.next = new Node<E>(element, p);// 插入元素,插入位置在p结点之前
		if (p == null) {
			this.rear = front.next;// 尾插入则需要修改尾指针
		}
		this.n++;
		return true;
	}

	/**
	 * 删除指定对象,操作成功则返回true
	 * 
	 * @param element
	 * @return
	 */
	public boolean remove(E element) {
		if (element == null || !(element instanceof Comparable)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Comparable<E> cmp = (Comparable<E>) element;
		Node<E> front = this.head;
		Node<E> p = front.next;// front结点是p的前驱结点
		while (p != null && (cmp.compareTo(p.data) > 0)) {// 比较对象大小
			front = p;
			p = p.next;
		}

		if (p == null || cmp.compareTo(p.data) == 0) {// 没有找到指定的结点,删除失败
			return false;
		}
		front.next = p.next;// 删除p结点
		if (p == this.rear) {
			this.rear = front;
		}
		this.n--;
		return true;
	}

	public static void main(String[] args) {
		SortedHeadSinglyLinkedList<Integer> list = new SortedHeadSinglyLinkedList<Integer>();
		int n = 10;
		System.out.print("insert:   ");
		for (int i = 0; i < n; i++) {
			int k = (int) (Math.random() * 100);// 产生随机数
			list.add(new Integer(k));
			System.out.print(k + "    ");
		}
		System.out.println("\nlist  " + list.toString());
	}
}