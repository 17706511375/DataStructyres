package com.study.stack;

/**
 * 链表实现栈
 * @author think
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        StackNode stackNode1 = new StackNode(1);
        StackNode stackNode2 = new StackNode(2);
        StackNode stackNode3 = new StackNode(3);
        StackNode stackNode4 = new StackNode(4);
        StackNode stackNode5 = new StackNode(5);
        linkedStack.push(stackNode1);
        linkedStack.push(stackNode2);
        linkedStack.push(stackNode3);
        linkedStack.push(stackNode4);
        linkedStack.push(stackNode5);
        linkedStack.show();

        StackNode pop = linkedStack.pop();
        pop = linkedStack.pop();
        pop = linkedStack.pop();
        pop = linkedStack.pop();
        pop = linkedStack.pop();
        pop = linkedStack.pop();
    }
}

class LinkedStack {

    private StackNode head = new StackNode(0);

    public StackNode getHead() {
        return head;
    }

    public void push(StackNode stackNode) {
        if (head.next == null) {
            head.next = stackNode;
            return;
        }
        StackNode temp = head.next;
        stackNode.next = temp;
        head.next = stackNode;
    }

    public StackNode pop() {
        StackNode temp = head.next;
        if (temp == null) {
            System.out.println("空了");
            return null;
        }
        head.next = temp.next;
        return temp;
    }

    public void show() {
        StackNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.no);
            temp = temp.next;
        }
    }


}

class StackNode {
    public int no;
    public StackNode next;

    public StackNode(int num) {
        this.no = num;
    }
}