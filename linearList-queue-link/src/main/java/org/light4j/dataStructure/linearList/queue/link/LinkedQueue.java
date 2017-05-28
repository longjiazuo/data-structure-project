package org.light4j.dataStructure.linearList.queue.link;

import org.light4j.dataStructure.linearList.Node;
import org.light4j.dataStructure.linearList.queue.QQueue;

/**
 * 链式队列
 * 
 * @author longjiazuo
 * @param <E>
 */
public class LinkedQueue<E> implements QQueue<E> {
	private Node<E> front;// 队列头结点
	private Node<E> rear;// 队列尾结点

	public LinkedQueue() {// 构造空队列
		this.front = null;
		this.rear = null;
	}

	/**
	 * 判断队列是否为空，若为空返回true
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this.front == null && this.rear == null;
	}

	/**
	 * 元素入队，操作成功返回true
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean enqueue(E element) {
		if (element == null) {// 空元素不能入队
			return false;
		}
		Node<E> q = new Node<E>(element);
		if (!isEmpty()) {// 队列不为空，新的结点作为新的队尾结点
			this.rear.next = q;
		} else {// 队列为空，新的结点作为头结点
			this.front = q;
		}
		this.rear = q;// 队尾结点指向新结点q
		return true;
	}

	/**
	 * 出队，返回当前对头元素，若队列为空则返回null
	 * 
	 * @return
	 */
	@Override
	public E dequeue() {
		if (!isEmpty()) {
			E temp = this.front.data;// 取得对头元素
			this.front = this.front.next;// 删除对头结点
			if (this.front == null) {// 如果对头为空，则是空队列，队尾也置为空
				this.rear = null;
			}
			return temp;
		}
		return null;
	}

	/**
	 * 返回队列中各元素的字符串表示
	 */
	@Override
	public String toString() {
		String str = "(";
		Node<E> p = this.front;
		while (p != null) {
			if (p == this.rear) {// 尾结点
				str += p.data;
			} else {
				str += p.data + ",";
			}
			p = p.next;
		}
		return str + ")";
	}
}