package org.light4j.dataStructure.linearList.linkList;

import org.light4j.dataStructure.linearList.LList;

public class Test {
	public static void main(String[] args) {
		LList<String> linkedList = new SinglyLinkedList<String>();
		// 添加A,B,C三个元素
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C");
		// 输出元素个数
		System.out.println("元素个数是："+linkedList.length());
	}
}