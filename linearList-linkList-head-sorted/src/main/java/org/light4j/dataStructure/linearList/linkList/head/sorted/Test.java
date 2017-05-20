package org.light4j.dataStructure.linearList.linkList.head.sorted;

public class Test {
	public static void main(String[] args) {
		SortedHeadSinglyLinkedList<Integer> list = new SortedHeadSinglyLinkedList<Integer>();
		int n = 10;
		System.out.print("insert:   ");
		for (int i = 0; i < n; i++) {
			int k = (int) (Math.random() * 100);// 产生随机数
			list.add(new Integer(k));
			System.out.print(k + "    ");
		}
		System.out.println("\nlist  " + list.toString());
	}
}
