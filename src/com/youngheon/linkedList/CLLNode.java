package com.youngheon.linkedList;

public class CLLNode {
    private int data;
    private CLLNode next;
    private CLLNode previous;
    public CLLNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(CLLNode next){
        this.next = next;
    }
    public CLLNode getNext(){
        return this.next;
    }
    public void setPrevious(CLLNode previous){
        this.previous = previous;
    }
    public CLLNode getPrevious(){
        return this.previous;
    }

    //원형리스트에서는 NULL을 가리키는 끝이 없다 =>무한 루프로 빠짐

    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    int CircularListLength(CLLNode headNode){
        int length = 0;
        CLLNode currentNode = headNode;
        while(currentNode!=null){
            length++;
            currentNode = currentNode.getNext();
            if(currentNode == headNode)
                break;
        }
        return length;
    }
    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    void PrintCircularListData(CLLNode headNode){
        CLLNode CLLNode = headNode;
        while(CLLNode!=null){
            System.out.print(CLLNode.getData()+"->");
            CLLNode = CLLNode.getNext();
            if(CLLNode==headNode) break;
        }
        System.out.println("("+ CLLNode.getData()+")headNode");
    }

    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    void InsertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode ==null) headNode = nodeToInsert;
        else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    void InsertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if(headNode == null){
            headNode = nodeToInsert;
        }else{
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }
    }

    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    void DeleteLastNodeFromCLL(CLLNode headNode){
        CLLNode temp = headNode;
        CLLNode currentNode = headNode;
        if(headNode==null){
            System.out.println("List Empty");
            return;
        }
        while(currentNode.getNext()!=headNode){
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        currentNode = null;
        return;
    }
    //시간복잡도 : O(n)
    //공간복잡도 : O(1)
    void DeleteFrontNodeFromCLL(CLLNode headNode){
        CLLNode temp = headNode;
        CLLNode current = headNode;
        if(headNode == null){
            System.out.println("List Empty");
            return;
        }
        while(current.getNext()!=headNode)
            current.setNext(current.getNext());
        current.setNext(headNode.getNext());
        headNode = headNode.getNext();
        temp = null;
        return;
    }

}
