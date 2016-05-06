package com.youngheon.queue;

import com.youngheon.linkedList.ListNode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LLQueue extends Queue {
    private ListNode frontNode;
    private ListNode rearNode;
    private LLQueue{
        this.frontNode = null;
        this.rearNode = null;
    }
    public static LLQueue createQueue(){
        return new LLQueue();
    }
    public boolean isEmpty(){
        return (frontNode==null);
    }
    public void enQueue(int data){
        ListNode newNode = new ListNode(data);
        if(rearNode!=null){
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if(frontNode == null){
            frontNode = rearNode;
        }
    }
    public int deQueue(){
        int data = null;
        if(isEmpty()){
            throw new EmptyQueueException("Queue Empty");

        }else{
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }

}
