package org.light4j.dataStructure.linearList.queue;

/**
 * 队列接口
 * 
 * @author longjiazuo
 */
public interface QQueue<E> {
	/**
	 * 判断队列是否为空，若为空返回true
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 元素入队，操作成功返回true
	 * 
	 * @param element
	 * @return
	 */
	boolean enqueue(E element);

	/**
	 * 出队，返回当前对头元素，若队列为空则返回null
	 * 
	 * @return
	 */
	E dequeue();
}
