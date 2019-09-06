package com.study.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArray arrayQueue = new CircleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s:��ʾ����");
			System.out.println("e:�˳�����");
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
		}
		System.out.println("�����˳�");
	}

}

class CircleArray {

	private int maxSize;
	private int front; // ָ����еĵ�һ��Ԫ��
	private int rear; // ָ����е����һ��Ԫ�صĺ�һ��λ��
	private int[] arr;

	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	// �ж϶����Ƿ���
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
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
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// ���ݳ�����
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}

		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// ��������
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�ľ������");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	// ��ʾ����ͷ����
		public int headQueue() {
			if (isEmpty()) {
				throw new RuntimeException("����Ϊ��û������");
			}
			return arr[front + 1];
		}
	

	// �����ǰ��Ч���ݵĸ���
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

}
