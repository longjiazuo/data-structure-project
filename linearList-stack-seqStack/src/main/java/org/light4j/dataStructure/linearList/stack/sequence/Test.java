package org.light4j.dataStructure.linearList.stack.sequence;

import org.light4j.dataStructure.linearList.stack.SStack;

public class Test {
	public static void main(String[] args) {
		SStack<String> stack = new SeqStack<String>();
		System.out.println(stack.isEmpty());//判空
		stack.push("A");//入栈
		stack.push("B");
		stack.push("C");
		System.out.println(stack.toString());
		stack.pop();// 出栈
		stack.push("D");
		stack.get();// 取栈顶元素
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());//判空
	}
}
