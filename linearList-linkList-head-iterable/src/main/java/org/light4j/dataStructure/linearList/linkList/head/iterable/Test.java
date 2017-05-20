package org.light4j.dataStructure.linearList.linkList.head.iterable;

import java.util.Iterator;

public class Test {
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IterableHeadSinglyLinkedList<String> list = new IterableHeadSinglyLinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
