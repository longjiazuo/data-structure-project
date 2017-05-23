package org.light4j.dataStructure.linearList.linkList.doubleLink;

import org.light4j.dataStructure.linearList.LList;

public class Test {
	public static void main(String[] args) {
		LList<String> list = new DoubleLinkedList<String>();
		list.add("A");
		list.add("B");
		System.out.println(list.toString());
		list.remove(2);// 移除元素
		System.out.println(list.toString());
		list.add(5, "C");// 追加元素
		list.add(2, "D");//追加元素
		System.out.println(list.toString());
	}
}
