package com.study.linekdlist;

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// �����ڵ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
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
	// ��ʼ��һ��ͷ�ڵ�
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	// �������
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ����
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		// ���˳�ѭ��ʱ,temp��ָ������������
		temp.next = heroNode;
	}

	// �������
	public void addByOrder(HeroNode heroNode) {

		// �ҵ�temp�����λ�õ�ǰһ���ڵ�
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) { // ˵��temp�Ѿ�������������
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

		// �ж�flag��ֵ

		if (flag) {
			System.out.printf("��������ˣ�%d", heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}

	}

	// �޸Ľڵ㣬���ݱ�����޸� no
	public void update(HeroNode heroNode) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
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
			System.out.printf("û�ҵ�%d", heroNode.no);
			System.out.println();
		}

	}

	// head�ڵ㲻�ܶ� ��Ҫtemp�ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
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
			System.out.printf("û�д�Ԫ��%d\n", no);
		}
	}

	// ��ȡ������ĸ���
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

	// ��������
	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
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

	// ��ȡ�������еĵ�K���ڵ�
	// 1��дһ����������head�ڵ㣬����һ��index��index��ʾ������index���ڵ�
	// �Ȱ������ͷ��β�������õ������ܳ���
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
		HeroNode next = null;//ָ��ǰ�ڵ����һ���ڵ�
		HeroNode reversehead = new HeroNode(0, "", "");
		while (current != null) {
			next = current.next; //����ʱ���浱ǰ�ڵ����һ���ڵ㣬������Ҫʹ��
			current.next = reversehead.next;//��current����һ���ڵ�ָ���µ��������ǰ��
			reversehead.next = current;
			current = next;
		}
		
		head.next = reversehead.next;
	}
}

//����HeroNode
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