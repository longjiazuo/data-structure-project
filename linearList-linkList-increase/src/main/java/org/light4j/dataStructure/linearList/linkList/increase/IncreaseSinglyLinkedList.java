package org.light4j.dataStructure.linearList.linkList.increase;

import org.light4j.dataStructure.linearList.LList;
import org.light4j.dataStructure.linearList.linkList.Node;
import org.light4j.dataStructure.linearList.linkList.SinglyLinkedList;

/**
 * 增强的单链表，比单链表类SinglyLinkedList增加了一些常用的方法
 * 
 * @author longjiazuo
 * 
 * @param <E>
 */
public class IncreaseSinglyLinkedList<E> extends SinglyLinkedList<E> {

	/**
	 * 构造空单链表
	 */
	public IncreaseSinglyLinkedList() {
		super();
	}

	/**
	 * 构造指定头结点的单链表
	 * 
	 * @param head
	 */
	public IncreaseSinglyLinkedList(Node<E> head) {
		super(head);
	}

	/**
	 * 由指定数组中的多个对象构造单链表
	 * 
	 * @param elements
	 */
	public IncreaseSinglyLinkedList(E[] elements) {
		if (elements == null) {// 数组元素不允许为空
			throw new RuntimeException("elements is null");
		}
		Node<E> p = null;// 记录当前节点,遍历
		for (int i = 0; i < elements.length; i++) {
			E element = elements[i];
			if (element == null) {// 元素值不允许为空
				throw new RuntimeException("the value of elements is null");
			}
			Node<E> node = new Node<E>(element);// 新建元素结点
			if (this.head == null) {// 如果头结点为空则头指针指向该结点
				this.head = node;
			} else {
				p.next = node;// 当前节点的next域指向该新建结点
			}
			p = node;// p指向当前节点
		}
	}

	/**
	 * 以单链表list构造新的单链表,复制单链表
	 * 
	 * @param list
	 */
	public IncreaseSinglyLinkedList(IncreaseSinglyLinkedList<E> list) {
		if (list == null) {// list不允许为空
			throw new RuntimeException("list is null");
		}
		Node<E> p = list.head;
		Node<E> q = null;
		while (p != null) {
			Node<E> node = new Node<E>(p.data);// 创建要新追加的结点;
			if (q == null) {// 头结点为空则头指针直接指向新追加的结点
				this.head = node;// 要新追加的结点;
			} else {
				q.next = node;// 把追加的结点添加到最后一个结点之后
			}
			q = node;// q结点指向node
			p = p.next;
		}
	}

	/**
	 * 将指定单链表list链接在当前单链表之后
	 * 
	 * @param list
	 */
	public void concat(IncreaseSinglyLinkedList<E> list) {
		if (list == null) {// list不允许为空
			throw new RuntimeException("list is null");
		}
		Node<E> p = this.head;
		while (p.next != null) {// 循环找到当前链表的最后一个结点
			p = p.next;
		}
		if (this.head == null) {// 若当前链表的头结点为空,则当前链表的头结点指向被连接链表的头结点
			this.head = list.head;
		} else {// 若当前链表的头结点为空,则当前链表的最后一个结点的next域指向被连接链表的头结点
			p.next = list.head;
		}
	}

	/**
	 * 查找指定对象,若找到则返回结点,否则返回null
	 * 
	 * @param element
	 * @return
	 */
	public Node<E> search(E element) {
		if (element == null) {
			return null;
		}
		Node<E> p = this.head;
		while (p != null) {
			E targetElement = p.data;
			if (element.equals(targetElement)) {
				return p;
			}
			p = p.next;
		}
		return null;
	}

	/**
	 * 判断单链表是否包含指定对象,包含则返回true,不包含返回false
	 * 
	 * @param element
	 * @return
	 */
	public boolean contain(E element) {
		return search(element) != null;
	}

	/**
	 * 移除首次出现的指定对象,移除成功返回true,移除失败返回false
	 * 
	 * @param element
	 * @return
	 */
	public boolean remove(E element) {
		if (element == null || this.head == null) {// 被移除元素和头结点不能为空
			return false;
		}

		E targetElement = this.head.data;
		if (element.equals(targetElement)) {// 头结点先特殊处理,判断头结点数据是否匹配
			this.head = this.head.next;// 头删除，头结点指针移动
			return true;
		}

		Node<E> p = this.head;
		Node<E> pre = null;// 记录当前结点的上一个结点
		while (p.next != null) {// 判断头结点之后的别的结点
			targetElement = p.next.data;
			if (element.equals(targetElement)) {
				pre = p;// 找到匹配元素,pre记录当前节点p
			}
			p = p.next;
			if (pre != null) {// pre不为空说明已经找到匹配的元素
				break;// 跳出循环
			}
		}
		if (p != null && pre != null) {
			pre.next = p.next;// 中间删除,头指针不移动
			return true;
		}
		return false;
	}

	/**
	 * 将单链表中的obj对象替换为对象element,成功返回true,失败返回false
	 * 
	 * @param obj
	 * @param element
	 * @return
	 */
	public boolean replace(Object obj, E element) {
		if (obj == null || element == null) {// 对象不能为空值
			return false;
		}
		if (this.head == null) {// 头结点不能为空
			return false;
		}
		Node<E> p = this.head;
		int i = 0;
		while (p != null) {
			E targetElement = p.data;// 要进行匹配的目标元素
			if (obj.equals(targetElement)) {// 找到匹配元素
				i++;// 用i记录匹配的个数
				p.data = element;// 元素替换
			}
			p = p.next;
		}
		if (i != 0) {// i不等于0说明找到匹配的元素,返回true
			return true;
		}
		return false;
	}

	/**
	 * 比较两条单链表是否相等,相等返回true,不相等返回false
	 * 
	 * @param obj
	 * @param element
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj == null) {// 单链表不允许为空
			return false;
		}
		if (this == obj) {// 如果是同一个实例，返回true
			return true;
		}

		if ((obj instanceof LList)) {// 判断obj是否是LList的对象实例或者子类的实例
			@SuppressWarnings("unchecked")
			LList<E> originalList = (LList<E>) obj;
			if (this.length() != originalList.length()) {// 链表长度不相等返回false
				return false;
			}
			for (int i = 0; i < originalList.length(); i++) {
				E originalElement = originalList.get(i);
				E targetElement = this.get(i);
				if (originalElement == null || targetElement == null) {// 元素值不能为空
					return false;
				}
				if (!originalElement.equals(targetElement)) {// 找到不匹配的元素返回false
					return false;
				}
			}
			return true;
		}
		return false;
	}
}