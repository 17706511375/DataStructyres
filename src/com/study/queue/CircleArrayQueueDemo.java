package com.study.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArray arrayQueue = new CircleArray(4);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s:显示队列");
			System.out.println("e:退出队列");
			System.out.println("a:添加数据到队列");
			System.out.println("g:从队列取数据");
			System.out.println("h:查看队列头部");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int result = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n", result);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int result = arrayQueue.headQueue();
					System.out.printf("队列的头数据是%d\n", result);
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
		System.out.println("程序退出");
	}

}

class CircleArray {

	private int maxSize;
	private int front; // 指向队列的第一个元素
	private int rear; // 指向队列的最后一个元素的后一个位置
	private int[] arr;

	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	// 判断队列是否满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("队列满，不能加入数据");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	// 数据出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}

		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// 遍历数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空，木有数据");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	// 显示队列头数据
		public int headQueue() {
			if (isEmpty()) {
				throw new RuntimeException("队列为空没有数据");
			}
			return arr[front + 1];
		}
	

	// 求出当前有效数据的个数
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

}
