package org.light4j.dataStructure.linearList.seqList;

import org.light4j.dataStructure.linearList.LList;

public class Josephus {
	private LList<String> seqList;
	private int distance;

	// 创建约瑟夫环并求解,参数指定环长度,起始位置,计数
	public Josephus(int number, int distance) {
		if(number<=0||distance<=0){
			throw new RuntimeException("number或distance参数输入不合法");
		}
		this.distance=distance;
		this.seqList = new SeqList<String>(number);// 顺序表元素类型是字符串,指定容量
		for (int i = 0; i < number; i++) {
			this.seqList.add((char) ('A' + i) + "");// 添加字符串对象
		}
		System.out.print("约瑟夫环(" + number + "," + distance + "), ");
		System.out.println(this.seqList.toString());// 显示顺序表所有对象的字符串表示
	}

	public void sentence(int start) {
		int index=start-1;
		while (this.seqList.length() > 1) {
			index = (index + this.distance - 1) % this.seqList.length();
			System.out.print("删除" + this.seqList.remove(index).toString() + ", ");// 删除指定位置元素对象
			System.out.println(this.seqList.toString());
		}
		System.out.println("被赦免者是"+this.seqList.get(0).toString());
	}

	public static void main(String[] args) {
		new Josephus(5,2).sentence(1);
	}
}
