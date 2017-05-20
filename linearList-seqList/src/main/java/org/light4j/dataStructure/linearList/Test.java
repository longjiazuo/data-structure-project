package org.light4j.dataStructure.linearList;

public class Test {
	public static void main(String[] args) {
		// 初始化默认值容量的SeqList
		LList<String> defalutValueList = new SeqList<String>();
		// 添加A,B,C三个元素
		defalutValueList.add("A");
		defalutValueList.add("B");
		defalutValueList.add("C");
		// 输出元素个数
		System.out.println(defalutValueList.length());
		// 初始化容量值为10的SeqList
		LList<String> specifiedValueList = new SeqList<String>(10);
		// 添加D,E,F,G四个元素
		specifiedValueList.add("D");
		specifiedValueList.add("E");
		specifiedValueList.add("F");
		specifiedValueList.add("G");
		// 输出元素个数
		System.out.println(specifiedValueList.length());
	}
}