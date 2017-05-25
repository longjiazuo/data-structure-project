package org.light4j.dataStructure.stack.seqStack;

import org.light4j.dataStructure.stack.SStack;

public class SeqStack<E> implements SStack<E> {
	private Object[] value;// 储存栈的数据元素的数组
	private int top;// 栈顶元素下标

	public SeqStack() {// 构造默认容量的空栈
		this(16);// 初始化栈的容量为16
	}

	public SeqStack(int capacity) {
		this.value = new Object[Math.abs(capacity)];
		this.top = -1;// 栈顶下标初始化为-1
	}

	/**
	 * 判断栈是否为空，若为空则返回true
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean push(E element) {
		if (element == null) {// 元素不允许为空
			return false;
		}
		if (this.top == value.length - 1) {// 栈满则需要扩充容量
			Object[] temp = this.value;
			this.value = new Object[temp.length * 2];// 扩充数组容量为原来的数组容量的两倍
			for (int i = 0; i < temp.length; i++) {// 复制元素到新的数组
				this.value[i] = temp[i];
			}
		}
		this.top++;// 栈顶加1
		this.value[top] = element;// 把入栈的元素置于栈顶
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E pop() {
		if (isEmpty()) {// 如果是空栈则返回null
			return null;
		}
		return (E) this.value[top--];// 取出栈顶元素,栈顶元素改变,top减1
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get() {// 如果是空栈则返回null
		if (isEmpty()) {
			return null;
		}
		return (E) this.value[top];// 返回栈顶元素，栈顶元素未改变,top不变
	}

	@Override
	public String toString() {
		String str = "(";
		for (int i = 0; i < this.value.length; i++) {
			if (i == top) {// 栈顶元素
				str += this.value[i];
				break;// 遍历完栈顶元素跳出循环
			} else {
				str += this.value[i] + ",";
			}
		}
		return str + ")";
	}
}