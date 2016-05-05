package com.youngheon.stack;

public class DynArrayStack {
    private int top;
    private int capacity;
    private int [] array;
    public DynArrayStack(){
        capacity = 1;
        array = new int[capacity];
        top=-1;
    }
    public boolean isEmpty(){
        return (top==-1);

    }
    public boolean isStackFull(){
        return (top==capacity-1); // return == array.length);
    }
    public void push(int data){
        if(isStackFull()){
            doubleStack();
        }
        array[++top]=data;
    }
    public void doubleStack(){
        int newArray[] = new int [capacity*2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = capacity*2;
        array = newArray;
    }
    public int pop(){
        if(isEmpty())
            System.out.println("Stack Overflow");
        else
            return (array[top--]);
    }
    public void deleteStack(){
        top = -1;
    }
}
