package com.study.linekdlist;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// 创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		SingelLinkedList sinLinkedList = new SingelLinkedList();

		/*
		 * sinLinkedList.add(hero2); sinLinkedList.add(hero1); sinLinkedList.add(hero3);
		 * sinLinkedList.add(hero4); sinLinkedList.list();
		 */
		sinLinkedList.addByOrder(hero1);
		sinLinkedList.addByOrder(hero2);
		sinLinkedList.addByOrder(hero3);
		sinLinkedList.addByOrder(hero4);
		sinLinkedList.list();
		SingelLinkedList.reverseList(sinLinkedList.getHead());
		System.out.println();
		sinLinkedList.list();

	}
}

class SingelLinkedList {
	// 初始化一个头节点
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	// 无序添加
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		// 遍历链表找到最后
		while (true) {
			// 找到最后
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// 当退出循环时,temp就指向了链表的最后
		temp.next = heroNode;
	}

	// 有序添加
	public void addByOrder(HeroNode heroNode) {

		// 找的temp是添加位置的前一个节点
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) { // 说明temp已经是在链表的最后
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		// 判断flag的值

		if (flag) {
			System.out.printf("不能添加了：%d", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}

	}

	// 修改节点，根据编号来修改 no
	public void update(HeroNode heroNode) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}

		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		} else {
			System.out.printf("没找到%d", heroNode.no);
			System.out.println();
		}

	}

	// head节点不能动 需要temp节点找到待删除节点的前一个节点
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("没有此元素%d\n", no);
		}
	}

	// 获取单链表的个数
	public int getSize(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode curNode = head.next;
		while (curNode != null) {
			length++;
			curNode = curNode.next;
		}
		return length;
	}

	// 遍历链表
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// 获取单链表中的第K个节点
	// 1编写一个方法接受head节点，接受一个index，index表示倒数第index个节点
	// 先把链表从头到尾遍历，得到链表总长度
	public HeroNode findLastIndexNode(HeroNode head, int index) {
		if (head == null) {
			return null;
		}

		int size = this.getSize(head);

		if (index <= 0 || index > size) {
			return null;
		}
		HeroNode temp = head.next;

		for (int i = 0; i < size - index; i++) {
			temp = temp.next;
		}
		return temp;
	}


	
	public static void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null ) {
			return;
		}
		
		HeroNode current = head.next;
		HeroNode next = null;//指向当前节点的下一个节点
		HeroNode reversehead = new HeroNode(0, "", "");
		while (current != null) {
			next = current.next; //先暂时保存当前节点的下一个节点，后面需要使用
			current.next = reversehead.next;//将current的下一个节点指向新的链表的最前端
			reversehead.next = current;
			current = next;
		}
		
		head.next = reversehead.next;
	}
}

//定义HeroNode
class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}