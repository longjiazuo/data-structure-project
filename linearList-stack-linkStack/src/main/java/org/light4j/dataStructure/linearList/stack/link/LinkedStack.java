package org.light4j.dataStructure.linearList.stack.link;

import org.light4j.dataStructure.linearList.Node;
import org.light4j.dataStructure.linearList.stack.SStack;

/**
 * 链式栈
 * 
 * @author longjiazuo
 * 
 * @param <E>
 */
public class LinkedStack<E> implements SStack<E> {
	private Node<E> top;// 栈顶元素结点

	public LinkedStack() {
		this.top = null;
	}

	/**
	 * 判断栈是否为空，若为空则返回true
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this.top == null;
	}

	/**
	 * 元素入栈，成为新的栈顶元素，若操作成功返回true
	 */
	@Override
	public boolean push(E element) {
		if (element == null) {// 空对象不能入栈
			return false;
		}
		this.top = new Node<E>(element, this.top);// 新的元素作为栈顶元素，原来的栈顶元素作为其后继元素
		return true;
	}

	/**
	 * 元素出栈，返回当前栈顶元素，栈顶元素改变，若栈为空则返回null
	 */
	@Override
	public E pop() {
		if (!isEmpty()) {// 判断是否为空空栈
			E temp = this.top.data;// 取栈顶元素
			this.top = this.top.next;// 删除原来的栈顶结点，改变栈顶元素
			return temp;// 返回原来的栈顶元素值
		}
		return null;
	}

	/**
	 * 取栈顶元素值，元素未出栈，栈顶元素未改变
	 */
	@Override
	public E get() {
		if (!isEmpty()) {// 判断是否为空栈
			return this.top.data;// 返回栈顶元素值
		}
		return null;
	}

	/**
	 * 返回栈中各元素的字符串表示
	 */
	@Override
	public String toString() {
		String str = "(";
		Node<E> p = this.top;// 新建一个结点指向栈顶结点top
		while (p != null) {
			if (p.next == null) {// 判断是否有后继结点
				str += p.data;
			} else {
				str += p.data + ",";
			}
			p = p.next;
		}
		return str + ")";
	}
}