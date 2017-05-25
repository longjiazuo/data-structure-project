package org.light4j.dataStructure.stack.seqStack;

import org.light4j.dataStructure.stack.SStack;

public class Test {
	public static void main(String[] args) {
		SStack<String> stack = new SeqStack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.pop();// 出栈
		stack.push("D");
		stack.get();// 取栈顶元素
		System.out.println(stack.toString());
	}
}
