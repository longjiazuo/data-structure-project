package org.light4j.dataStructure.linearList.queue.seqQueue;

import org.light4j.dataStructure.linearList.queue.QQueue;

/**
 * 顺序队列
 * 
 * @author longjiazuo
 * @param <E>
 */
public class SeqQueue<E> implements QQueue<E> {

	private Object[] value;// 存储队列数据元素的数组
	private int front;// 对头下标
	private int rear;// 队尾下标

	public SeqQueue(int capacity) {// 构造指定容量的空队列
		value = new Object[Math.abs(capacity)];
		this.front = -1;
		this.rear = -1;
	}

	public SeqQueue() {// 构造默认空队列
		this(16);
	}

	/**
	 * 判断队列是否为空，若为空返回true
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return this.front == -1 && this.rear == -1;
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
		if (isEmpty()) {// 空队列
			this.value[0] = element;
			this.front++;
			this.rear++;
		} else {// 非空队列，入队更改队尾结点指向
			if (this.rear == this.value.length - 1) {// 队列满则扩容
				Object[] temp = this.value;
				this.value = new Object[this.value.length * 2];// 扩容为当前队列的两倍
				for (int i = 0; i < temp.length; i++) {
					this.value[i] = temp[i];
				}
			}
			this.value[++this.rear] = element;//
		}
		return true;
	}

	/**
	 * 出队，返回当前对头元素，若队列为空则返回null
	 * 
	 * @return
	 */
	@Override
	public E dequeue() {
		if (isEmpty()) {// 如果队列为空返回null
			return null;
		}
		@SuppressWarnings("unchecked")
		E temp = (E) this.value[this.front];
		this.value[this.front++] = null;
		return temp;
	}

	/**
	 * 返回栈中各元素的字符串表示
	 */
	@Override
	public String toString() {
		String str = "(";
		if (!isEmpty()) {// 判断是否非空
			for (int i = this.front; i <= this.rear; i++) {// 从对头 到队尾
				if (i == this.rear) {
					str += this.value[i];
				} else {
					str += this.value[i] + ",";
				}
			}
		}
		return str + ")";
	}
}