package com.study.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.show();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
    }
}
class ArrayStack{
    public int maxSize;
    public int[] arr;
    public int top = -1;
    public  ArrayStack(int size){
        this.maxSize = size;
        arr = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("Õ»ÂúÁË");
            return;
        }
        top++;
        arr[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("Õ»¿ÕÁË");
        }
        return arr[top--];
    }

    public void show(){
        if (isEmpty()){
            return;
        }
        for (int i = top;i >= 0;i--){
            System.out.printf("arr[%d] : %d \n",i,arr[i]);
        }
    }

}
