package org.light4j.dataStructure.stack;

/**
 * 栈接口
 * 
 * @author longjiazuo
 */
public interface SStack<E> {
	/**
	 * 判断栈是否为空，若为空则返回true
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * element元素入栈，若操作成功返回true
	 * 
	 * @param element
	 * @return
	 */
	boolean push(E element);

	/**
	 * 出栈，返回当前栈顶元素，若栈空返回null
	 * 
	 * @return
	 */
	E pop();

	/**
	 * 取栈顶元素值，未出栈，若栈空返回null
	 * 
	 * @return
	 */
	E get();
}
