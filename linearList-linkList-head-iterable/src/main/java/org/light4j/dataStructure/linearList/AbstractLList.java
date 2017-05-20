package org.light4j.dataStructure.linearList;

import java.util.Iterator;

/**
 * 抽象线性表类
 * 
 * @author longjiazuo
 */
public abstract class AbstractLList<E> implements Iterable<E> {

	/**
	 * 获得迭代器对象,抽象方法,由子类进行实现
	 */
	public abstract Iterator<E> iterator();

	/**
	 * 返回线性表所有元素组成的字符串
	 */
	@Override
	public String toString() {
		String str = "(";
		Iterator<E> it = iterator();// 获取一个迭代器对象
		while (it.hasNext()) {// 判断是否有后继元素
			E element = it.next();// 获取后继元素
			str += element.toString();
			if (it.hasNext()) {
				str += ",";
			}
		}
		return str + ")";
	}

	/**
	 * 判断线性表是否包含指定的元素
	 * 
	 * @param obj
	 * @return
	 */
	public boolean contain(Object obj) {
		if (obj != null) {
			Iterator<E> it = iterator();
			while (it.hasNext()) {
				E elment = it.next();
				if (obj.equals(elment)) {// 如果找到相等的则返回true
					return true;
				}
			}
		}
		return false;
	}
}