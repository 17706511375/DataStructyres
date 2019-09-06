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
		sinLinkedList.addByOrder(hero2);
		sinLinkedList.addByOrder(hero1);
		sinLinkedList.addByOrder(hero4);
		sinLinkedList.addByOrder(hero3);
		sinLinkedList.list();

		sinLinkedList.delete(20);

		sinLinkedList.list();
	}
}

class SingelLinkedList {
	// 初始化一个头节点
	private HeroNode head = new HeroNode(0, "", "");

	// 找到最后的节点 将最后节点的next域指向传入的节点
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
	
	
	//head节点不能动 需要temp节点找到待删除节点的前一个节点
	
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
		}else {
			System.out.printf("没有此元素%d\n",no);
		}
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