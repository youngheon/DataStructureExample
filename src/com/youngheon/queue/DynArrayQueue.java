package com.youngheon.queue;

/**
 * Created by Young-heon on 2016. 5. 6..
 */
public class DynArrayQueue {
    private int front;
    private int rear;
    private int capacity;
    private int [] array;
    private DynArrayQueue(){
        capacity = 1;
        front = -1;
        rear = -1;
        array = new int[1];

    }
    public static DynArrayQueue createDynArrayQueue(){
        return new DynArrayQueue();
    }
    public boolean isEmpty(){
        return (front==-1);
    }
    public boolean isFull(){
        return ((rear+1)%capacity == front);
    }
    public int getQueueSize(){
        if(front==-1) return 0;
        int size = (capacity-front+rear+1)%capacity;
        if(size==0){
            return capacity
        }else
            return size;

    }
    private void resizeQueue(){
        int initCapacity = capacity;
        capacity*=2;
        int [] oldArray = array;
        array = new int[this.capacity];
        for(int i=0;i<oldArray.length;i++){
            array[i] = oldArray[i];
        }
        if(rear<front){
            for(int i=0;i<front;i++){
                array[i+initCapacity]=this.array[i];
                array[i]=;
            }
            rear = rear+initCapacity;
        }
    }
    public void enQueue(int data){
        if(isFull()) resizeQueue();
        rear = (rear+1)%capacity;
        array[rear] = data;
        if(front==-1)
            front = rear;
    }
    public int deQueue(){
        int data = null;
        if(isEmpty()) throw new EmptyQueueException("Queue Empty");
        else{
            data = array[front];
            if(front==rear) front = rear = -1;
            else front = (front+1)%capacity;
        }
        return data;
    }
}
