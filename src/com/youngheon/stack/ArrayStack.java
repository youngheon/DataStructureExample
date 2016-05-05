package com.youngheon.stack;


public class ArrayStack {
    private int top;
    private int capacity;
    private int [] array;
    public ArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }
    public boolean isEmpty(){
        /* 이 조건이 참이면 1이 리턴 아니면 0 리턴 */
        return (top==-1);
    }
    public boolean isStackFull(){
        return (top==capacity-1); // return (top==array.length);
    }
    public void push(int data){
        if(isStackFull())
            System.out.println("Stack OverFlow");
        else
            array[++top] = data;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }
        else
            return (array[top--]);
    }
    public void deleteStack(){
        top=-1;
    }

}
