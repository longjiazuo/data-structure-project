package org.light4j.dataStructure.linearList.linkList.head;

import org.light4j.dataStructure.linearList.LList;

public class Test {
	public static void main(String[] args) {
		LList<String> list = new HeadSinglyLinkedList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(0, new String((char) ('A' + i) + ""));
		}
		System.out.println(list.toString());
		list.remove(0);//移除第一个元素
		System.out.println(list.toString());
	}
}
