package org.light4j.dataStructure.linearList.queue.sequence.cycle;

import org.light4j.dataStructure.linearList.queue.QQueue;

/**
 * 顺序循环队列
 * 
 * @author longjiazuo
 * @param <E>
 */
public class SeqCycleQueue<E> implements QQueue<E> {

	private Object[] value;// 存储队列数据元素的数组
	private int front;// 对头下标
	private int rear;// 队尾下标

	public SeqCycleQueue(int capacity) {// 构造指定容量的空循环队列
		value = new Object[Math.abs(capacity)];
		this.front = this.rear = 0;
	}

	public SeqCycleQueue() {// 构造默认空循环队列
		this(2);
	}

	/**
	 * 判断队列是否为空，若为空返回true
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this.front == this.rear;
	}

	/**
	 * 元素入队，操作成功返回true
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean enqueue(E element) {
		if (element == null) {// 空元素不允许入队
			return false;
		}
		if (this.front == (this.rear + 1) % this.value.length) {
			Object[] temp = this.value;
			this.value = new Object[temp.length * 2];// 扩充数组容量，扩充为原来容量的2倍
			int i = this.front;
			int j = 0;
			while (i != this.rear) {// 循环拷贝元素到新的数组
				this.value[j] = temp[i];// 元素复制
				i = (i + 1) % temp.length;
				j++;
			}
			this.front = 0;// 新队列的front为0
			this.rear = j;// 新队列的rear从索引j开始
		}
		this.value[this.rear] = element;
		this.rear = (this.rear + 1) % this.value.length;// rear下标变化规律
		return true;
	}

	/**
	 * 出队，返回当前对头元素，若队列为空则返回null
	 * 
	 * @return
	 */
	@Override
	public E dequeue() {
		if (!isEmpty()) {// 队列不为空
			@SuppressWarnings("unchecked")
			E temp = (E) this.value[this.front];// 取对头元素
			this.front = (this.front + 1) % this.value.length;// front下标变化规律
			return temp;
		}
		return null;
	}

	/**
	 * 返回栈中各元素的字符串表示
	 */
	@Override
	public String toString() {
		String str = "(";
		if (!isEmpty()) {// 判断是否非空
			for (int i = this.front; i <= this.rear - 1; i++) {// 从对头 到队尾
				if (i == this.rear - 1) {
					str += this.value[i];
				} else {
					str += this.value[i] + ",";
				}
			}
		}
		return str + ")";
	}
}