package com.study.linekdlist;

import java.util.Stack;

/** ��ʾջ�Ļ���ʹ�� */
public class TestStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    // ��ջ
    stack.add("a");
    stack.add("b");
    stack.add("c");

    // ��ս
    while (stack.size() > 0) {
      System.out.println(stack.pop());
    }
  }
}
