package com.study.linekdlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoys(5);
        circleLinkedList.show();

        circleLinkedList.countBoy(1,3,5);


    }
}

class CircleLinkedList {
    private Boy first = null;

    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("不能少于1人");
            return;
        }
        Boy currentBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                currentBoy = first;
            } else {
                currentBoy.setNext(boy);
                boy.setNext(first);
                currentBoy = boy;
            }
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        Boy currentBoy = first;
        while (true) {
            System.out.printf("编号为 %d \n", currentBoy.getNo());
            if (currentBoy.getNext() == first) {
                break;
            }
            currentBoy = currentBoy.getNext();
        }
    }

    /**
     * @param start 开始从第几个小孩报数
     * @param count 数数
     * @param nums
     */
    public void countBoy(int start, int count, int nums) {
        //教研数据
        if (first == null || start < 1 || start > nums) {
            return;
        }
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //计算开始从第几个小孩报数
        for ( int j = 0;j <start-1;j++){
            helper = helper.getNext();
            first = first.getNext();
        }
        while (helper != first) {
            for (int k = 0; k < count - 1; k++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.printf("出圈标号 %d \n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后的编号 %d",helper.getNo());
    }
}

class Boy {


    private int no;
    private Boy next;

    public Boy(int num) {
        this.no = num;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
