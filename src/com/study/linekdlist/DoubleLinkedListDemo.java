package com.study.linekdlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //双向链表的测试
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.list();
        System.out.println("修改");
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        System.out.println("删除");
        doubleLinkedList.delete(2);
        doubleLinkedList.list();


    }


}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    HeroNode2 getHead() {
        return head;
    }

    // head节点不能动 需要temp节点找到待删除节点的前一个节点
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空不能删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //temp.next = temp.next.next;
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("没有此元素%d\n", no);
        }
    }

    // 修改节点，根据编号来修改 no
    public void update(HeroNode2 heroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
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

    // 有序添加
    void addByOrder(HeroNode2 heroNode) {
        if (head.next == null) {
            head.next = heroNode;
            heroNode.pre = head;
            return;
        }
        // 找的temp是添加位置的前一个节点
        HeroNode2 temp = head;
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
            HeroNode2 next = temp.next;
            temp.next = heroNode;
            if (next == null) {
                heroNode.pre = temp;
                return;
            }
            next.pre = heroNode;
            heroNode.pre = temp;
            heroNode.next = next;
        }
    }


    // 无序添加 添加到链表的最后
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        // 遍历链表找到最后
        while (temp.next != null) {
            // 找到最后
            temp = temp.next;
        }
        // 当退出循环时,temp就指向了链表的最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 遍历链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }
}
