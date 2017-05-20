package org.light4j.dataStructure.linearList.seqList;

import org.light4j.dataStructure.linearList.LList;

public class SeqList<E> implements LList<E> { // 顺序表类，实现线性表接口
	private Object[] table; // 对象数组，私有成员
	private int n; // 顺序表长度

	/**
	 * 指定空表的默认容量
	 */
	public SeqList() {
		this(16);
	}

	/**
	 * 构造方法，创建指定容量的空表 Math.abs(i)返回参数的绝对值
	 */
	public SeqList(int capacity) {
		this.table = new Object[Math.abs(capacity)];
		this.n = 0;
	}

	/**
	 * 判断顺序表是否为空,若空返回true
	 */
	@Override
	public boolean isEmpty() {
		return this.n == 0;
	}

	/**
	 * 返回顺序表长度
	 */
	@Override
	public int length() {
		return this.n;
	}

	/**
	 * 返回index(初始值為0)位置的对象，若序号无效，返回null
	 */
	@Override
	public E get(int index) {
		if (index >= 0 && index < this.n) {
			return (E) this.table[index];
		}
		return null;
	}

	/**
	 * 设置index位置的对象为element，若操作成功，返回原对象，否则返回null
	 */
	@Override
	public E set(int index, E element) {
		if (index >= 0 && index < this.n && element != null) {
			E old = (E) this.table[index];
			this.table[index] = element;
			return old;
		}
		return null;
	}

	/**
	 * 在index位置插入element对象，若操作成功返回true，不能插入null
	 */
	@Override
	public boolean add(int index, E element) {
		if (element == null) {
			return false; // 不能插入null
		}
		if (this.n == this.table.length) { // 若数组满，则需要扩充顺序表的容量
			Object[] temp = this.table;
			this.table = new Object[temp.length * 2]; // 重新申请一个容量更大的数组
			for (int i = 0; i < temp.length; i++) {
				this.table[i] = temp[i]; // 复制数组元素,O(n)
			}
		}

		if (index < 0) {
			index = 0; // 下标容错
		}
		if (index > this.n) {
			index = this.n; // 下标容错
		}

		for (int j = this.n - 1; j >= index; j--) { // 元素后移，平均移动n/2
			this.table[j + 1] = this.table[j];
		}
		this.table[index] = element;
		this.n++;
		return true;
	}

	/**
	 * 在顺序表最好插入element对象
	 */
	@Override
	public boolean add(E element) {
		return this.add(this.n, element);
	}

	/**
	 * 移去index位置的对象，若操作成功，则返回被移去对象，否则返回null
	 */
	@Override
	public E remove(int index) {
		if (this.n != 0 && index >= 0 && index < this.n) {
			E old = (E) this.table[index];
			for (int i = index; i < this.n - 1; i++) { // 元素前移，平均移动n/2
				this.table[i] = this.table[i + 1];
			}
			this.table[this.n - 1] = null;
			this.n--;
			return old; // 若操作成功，则返回被移除对象
		}
		return null; // 未找到删除对象，操作不成功，返回null
	}

	/**
	 * 清空顺序表
	 */
	@Override
	public void clear() {
		if (this.n != 0) {
			for (int i = 0; i < this.n; i++) {
				this.table[i] = null;
			}
			this.n = 0;
		}
	}

	/**
	 * 重写toString()方法
	 */
	@Override
	public String toString() {
		String str = "(";
		if (this.n != 0) {
			for (int i = 0; i < this.n - 1; i++) {
				str += this.table[i].toString() + ",";
			}
			str += this.table[this.n - 1].toString();
		}
		return str + ")";
	}
}
