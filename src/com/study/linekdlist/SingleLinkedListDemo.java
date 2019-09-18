package com.study.linekdlist;

import java.util.Stack;

/** @author xianger */
public class SingleLinkedListDemo {
  public static void main(String[] args) {
    // 创建节点
    HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
    HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

    HeroNode hero5 = new HeroNode(5, "林冲", "豹子头");
    HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
    HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
    HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");
    HeroNode hero9 = new HeroNode(9, "林冲", "豹子头");

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

  /** 初始化第一个节点 */
  private HeroNode head = new HeroNode(0, "", "");

  HeroNode getHead() {
    return head;
  }

  // 无序添加
  private void add(HeroNode heroNode) {
    HeroNode temp = head;
    // 遍历链表找到最后
    while (temp.next != null) {
      // 找到最后
      temp = temp.next;
    }
    // 当退出循环时,temp就指向了链表的最后
    temp.next = heroNode;
  }

  // 有序添加
  void addByOrder(HeroNode heroNode) {

    // 找的temp是添加位置的前一个节点
    HeroNode temp = head;
    boolean flag = false;
    while (true) {
      // 说明temp已经是在链表的最后
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
  void list() {
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    HeroNode temp = head.next;
    while (temp != null) {
      System.out.println(temp);
      temp = temp.next;
    }
  }

  /**
   * @param head 获取单链表中的第K个节点
   * @param index 1编写一个方法接受head节点，接受一个index，index表示倒数第index个节点
   * @return 先把链表从头到尾遍历，得到链表总长度
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
    // 指向当前节点的下一个节点
    HeroNode next = null;
    HeroNode reversehead = new HeroNode(0, "", "");
    while (current != null) {
      // 先暂时保存当前节点的下一个节点，后面需要使用
      next = current.next;
      // 将current的下一个节点指向新的链表的最前端
      current.next = reversehead.next;
      reversehead.next = current;
      current = next;
    }

    head.next = reversehead.next;
  }

  // 从未到头打印单链表
  // 将各个节点压入栈中 利用栈的先进后出的特点 实现逆序打印的效果
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

  // 合并两个有序的单链表 合并后的链表仍然有序
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

// 定义HeroNode
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
