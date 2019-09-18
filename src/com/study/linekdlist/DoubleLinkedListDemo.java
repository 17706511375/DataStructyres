package com.study.linekdlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //˫������Ĳ���
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.list();
        System.out.println("�޸�");
        HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        System.out.println("ɾ��");
        doubleLinkedList.delete(2);
        doubleLinkedList.list();


    }


}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    HeroNode2 getHead() {
        return head;
    }

    // head�ڵ㲻�ܶ� ��Ҫtemp�ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("����Ϊ�ղ���ɾ��");
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
            System.out.printf("û�д�Ԫ��%d\n", no);
        }
    }

    // �޸Ľڵ㣬���ݱ�����޸� no
    public void update(HeroNode2 heroNode) {
        // �ж��Ƿ�Ϊ��
        if (head.next == null) {
            System.out.println("����Ϊ��");
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
            System.out.printf("û�ҵ�%d", heroNode.no);
            System.out.println();
        }
    }

    // �������
    void addByOrder(HeroNode2 heroNode) {
        if (head.next == null) {
            head.next = heroNode;
            heroNode.pre = head;
            return;
        }
        // �ҵ�temp�����λ�õ�ǰһ���ڵ�
        HeroNode2 temp = head;
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


    // ������� ��ӵ���������
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        // ���������ҵ����
        while (temp.next != null) {
            // �ҵ����
            temp = temp.next;
        }
        // ���˳�ѭ��ʱ,temp��ָ������������
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // ��������
    public void list() {
        if (head.next == null) {
            System.out.println("����Ϊ��");
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
