package com.youngheon.linkedList;


//시간복잡도 : o(n)
//공간복잡도 : o(1)

public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;
    public DLLNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(DLLNode next){
        this.next = next;
    }
    public DLLNode getNext(){
        return this.next;
    }
    public void setPrevious(DLLNode previous){
        this.previous = previous;
    }
    public DLLNode getPrevious(){
        return this.previous;
    }

    int getDLLLength(DLLNode headNode){
        int length = 0;
        DLLNode currentNode = headNode;
        while(currentNode!=null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }


    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position){
        if(headNode == null){ //시작 부분에 삽입
            return nodeToInsert;
        }
        int size = getDLLLength(headNode);
        if(position > size+1 || position <1){
            System.out.println("Position of nodeToInsert is invalid." + "The valid inputs are 1 to "+(size+1));
            return headNode;
        }
        if(position == 1){ //머리 부분에 노드 삽입
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        }else{
            DLLNode previousNode = headNode;
            int count = 1;
            while(count < position -1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode!=null)
                currentNode.setPrevious(nodeToInsert);
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }

        return headNode;
    }

    DLLNode DLLDelete(DLLNode headNode, int position){
        int size = getDLLLength(headNode);
        //위치가 주어진 연결 리스트의 사이즈보다 클 경우 폐기
        if(position > size || position < 1){
            System.out.println("Position of node to delete is invalid. "+ "The valid inputs are 1 to " + size);
            return headNode;

        }
        if(position == 1){ //시작 노드를 삭제
            DLLNode currentNode = headNode.getNext();
            headNode = null;
            currentNode.setPrevious(null);
            return currentNode;
        }else{ //끝이 될 때까지 내부의 노드를 삭제
            DLLNode previousNode = headNode;
            int count = 1;
            while(count<position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode != null){
                laterNode.setPrevious(previousNode);
            }
            currentNode = null;
        }

        return headNode;
    }
}


