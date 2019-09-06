package com.study.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s:��ʾ����");
			System.out.println("q:�˳�����");
			System.out.println("a:������ݵ�����");
			System.out.println("g:�Ӷ���ȡ����");
			System.out.println("h:�鿴����ͷ��");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int result = arrayQueue.getQueue();
					System.out.printf("ȡ����������%d\n", result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int result = arrayQueue.headQueue();
					System.out.printf("���е�ͷ������%d\n", result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}

			System.out.println("�����˳�");

		}
	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	// ��������

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	// �ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ������ݵ�����
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�����������ܼ�������");
			return;
		}

		arr[++rear] = n;
	}

	// ���ݳ�����

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		front++;
		return arr[front];
	}

	// ��������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�ľ������");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// ��ʾ����ͷ����
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��û������");
		}
		return arr[front + 1];
	}

}
