package org.light4j.dataStructure.linearList.linkList.increase;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String[] elements = { "A", "B", "C", "D", "E" };
		IncreaseSinglyLinkedList<String> list = new IncreaseSinglyLinkedList<String>(
				elements);
		IncreaseSinglyLinkedList<String> listByList = new IncreaseSinglyLinkedList<String>(
				list);

		System.out.println(list.toString());
		System.out.println(listByList.toString());
		// listByList.concat(list);// 拼接
		System.out.println(listByList);
		// System.out.println(listByList.search("A"));// 查找
		// System.out.println(listByList.contain("A"));// 包含
		// System.out.println(listByList.remove("B"));// 移除
		// System.out.println(listByList.replace("A", "M"));// 替换
		List<String> strlist = new ArrayList<String>();
		strlist.add("A");
		strlist.add("B");
		strlist.add("C");
		strlist.add("D");
		strlist.add("E");
		System.out.println(strlist.toString());
		System.out.println(listByList.equals(list));// 比较
		System.out.println(listByList.equals(strlist));// 比较
		System.out.println(listByList.toString());

	}
}