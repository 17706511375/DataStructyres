package com.study.linekdlist;

import java.util.Stack;

/** @author xianger */
public class SingleLinkedListDemo {
  public static void main(String[] args) {
    // �����ڵ�
    HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
    HeroNode hero2 = new HeroNode(2, "¬����", "������");
    HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
    HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

    HeroNode hero5 = new HeroNode(5, "�ֳ�", "����ͷ");
    HeroNode hero6 = new HeroNode(6, "�ֳ�", "����ͷ");
    HeroNode hero7 = new HeroNode(7, "�ֳ�", "����ͷ");
    HeroNode hero8 = new HeroNode(8, "�ֳ�", "����ͷ");
    HeroNode hero9 = new HeroNode(9, "�ֳ�", "����ͷ");

    SingelLinkedList sinLinkedList = new SingelLinkedList();
    sinLinkedList.addByOrder(hero1);
    sinLinkedList.addByOrder(hero3);
    sinLinkedList.addByOrder(hero5);
    sinLinkedList.addByOrder(hero7);
    sinLinkedList.addByOrder(hero9);
    sinLinkedList.list();

    SingelLinkedList sinLinkedList1 = new SingelLinkedList();
    sinLinkedList1.addByOrder(hero2);
    sinLinkedList1.addByOrder(hero4);
    sinLinkedList1.addByOrder(hero6);
    sinLinkedList1.addByOrder(hero8);
    sinLinkedList1.list();

    // SingelLinkedList.reverseList(sinLinkedList.getHead());
    // System.out.println();
    // sinLinkedList.list();
    SingelLinkedList.mergerList(sinLinkedList.getHead(), sinLinkedList1.getHead());

  }
}

class SingelLinkedList {

  /** ��ʼ����һ���ڵ� */
  private HeroNode head = new HeroNode(0, "", "");

  HeroNode getHead() {
    return head;
  }

  // �������
  private void add(HeroNode heroNode) {
    HeroNode temp = head;
    // ���������ҵ����
    while (temp.next != null) {
      // �ҵ����
      temp = temp.next;
    }
    // ���˳�ѭ��ʱ,temp��ָ������������
    temp.next = heroNode;
  }

  // �������
  void addByOrder(HeroNode heroNode) {

    // �ҵ�temp�����λ�õ�ǰһ���ڵ�
    HeroNode temp = head;
    boolean flag = false;
    while (true) {
      // ˵��temp�Ѿ�������������
      if (temp.next == null) {
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
  void list() {
    if (head.next == null) {
      System.out.println("����Ϊ��");
      return;
    }
    HeroNode temp = head.next;
    while (temp != null) {
      System.out.println(temp);
      temp = temp.next;
    }
  }

  /**
   * @param head ��ȡ�������еĵ�K���ڵ�
   * @param index 1��дһ����������head�ڵ㣬����һ��index��index��ʾ������index���ڵ�
   * @return �Ȱ������ͷ��β�������õ������ܳ���
   */
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

  static void reverseList(HeroNode head) {
    if (head.next == null || head.next.next == null) {
      return;
    }
    HeroNode current = head.next;
    // ָ��ǰ�ڵ����һ���ڵ�
    HeroNode next = null;
    HeroNode reversehead = new HeroNode(0, "", "");
    while (current != null) {
      // ����ʱ���浱ǰ�ڵ����һ���ڵ㣬������Ҫʹ��
      next = current.next;
      // ��current����һ���ڵ�ָ���µ��������ǰ��
      current.next = reversehead.next;
      reversehead.next = current;
      current = next;
    }

    head.next = reversehead.next;
  }

  // ��δ��ͷ��ӡ������
  // �������ڵ�ѹ��ջ�� ����ջ���Ƚ�������ص� ʵ�������ӡ��Ч��
  static void reversePrint(HeroNode head) {
    if (head.next == null) {
      return;
    }
    Stack<HeroNode> heroNodes = new Stack<>();
    HeroNode current = head.next;
    while (current != null) {
      heroNodes.push(current);
      current = current.next;
    }

    while (heroNodes.size() > 0) {
      System.out.println(heroNodes.pop());
    }
  }

  // �ϲ���������ĵ����� �ϲ����������Ȼ����
  static void mergerList(HeroNode head1, HeroNode head2) {
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        HeroNode newHead = new HeroNode(0, "", "");
        if (temp1.next == null){
            newHead.next = head2.next;
        }
        if (temp2.next == null){
            newHead.next = head1.next;
        }
        HeroNode temp3 = newHead;
        while (temp1 != null || temp2 != null){
            if (temp1 == null && temp2 != null){
                temp3.next = temp2;
                temp2 = temp2.next;
            }else if (temp2 == null && temp1 != null){
                temp3.next = temp1;
                temp1 = temp1.next;
            }else {
                if (temp1.no <= temp2.no){
                    temp3.next = temp1;
                    temp1 = temp1.next;
                }else {
                    temp3.next = temp2;
                    temp2 = temp2.next;
                }
            }
            temp3 = temp3.next;
        }
        System.out.println(newHead);
  }
}

// ����HeroNode
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
