package org.light4j.dataStructure.linearList.linkList.reverse;

public class Test {
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseSinglyLinkedList<Integer> rslk = new ReverseSinglyLinkedList<Integer>();
		for (int i = 1; i < 10; i++) {
			rslk.add(0, new Integer(i));
		}
		System.out.println("单链表: " + rslk.toString());
		rslk.reverse();
		System.out.println("逆转后的单链表: " + rslk.toString());
	}
}
