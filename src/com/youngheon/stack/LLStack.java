package com.youngheon.stack;


import com.youngheon.linkedList.ListNode;

import java.util.EmptyStackException;
import java.util.Stack;

public class LLStack extends Stack {
    private ListNode headNode;
    public LLStack(){
        this.headNode = new ListNode(null);
    }

    public void Push(int data){
        if(headNode == null){
            headNode = new ListNode(data);
        }else if(headNode.getData() == null){
            headNode.setData(data);
        }else{
            ListNode llNode = new ListNode(data);
            llNode.setNext(headNode);
            headNode = llNode;
        }
    }
    public int top(){
        if(headNode == null)
            return null;
        else
            return headNode.getData();
    }
    public int pop(){
        if(headNode == null)
             throw new EmptyStackException("Stack empty");
        else{
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }
    public boolean isEmpty(){
        if(headNode == null)
            return true;
        else
            return false;
    }
    public void deleteStack(){
        headNode = null;
    }

}
