package org.light4j.dataStructure.linearList.queue.sequence.cycle;

import org.light4j.dataStructure.linearList.queue.QQueue;

public class Test {
	public static void main(String[] args) {
		QQueue<String> queue = new SeqCycleQueue<String>();
		queue.dequeue();// 出栈
		System.out.println(queue.toString());
		queue.enqueue("A");// 元素在队尾入队
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		System.out.println(queue.toString());
		queue.dequeue();// 对头出队
		System.out.println(queue.toString());
	}
}