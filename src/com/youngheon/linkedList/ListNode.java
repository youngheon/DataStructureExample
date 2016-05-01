package com.youngheon.linkedList;


public class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(ListNode next){
        this.next = next;
    }
    public ListNode getNext(){
        return this.next;
    }

    //리스트 길이 반환
    //시간복잡도 : 크기가 n인 전체 리스트를 스캔하는데 O(n)
    //공간복잡도 : 하나의 임시 변수를 만듦 O(1)
    int ListLength(ListNode headNode){
        int length=0;
        ListNode currentNode = headNode;
        while(currentNode !=null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    //단일 연결 리스트의 삽입
    //1) 새 노드를 '헤드' 노드 포인터 앞 (가장 처음)
    //2) 새 노드를 '꼬리 노드 포인터 뒤 (리스트 가장 끝 삽입)
    //3) 새 노드를 리스트의 중간(랜덤위치)에 삽입

    //시간 복잡도 : 최악의 경우 O(n)
    //공간 복잡도 : 한개의 변수 O(1)
    ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position){

        if(headNode == null){ //최초로 설정
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if(position > size+1 || position < 1){
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " +(size+1));
            return headNode;
        }
        if (position == 1) { //첫 노드 삽입
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }else{ // 중간과 끝에 노드를 삽입
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;

    }


    //시간복잡도 : O(n)  맨 마지막 삭제 할 경우
    //공간복잡도 : O(1)
    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position){
        int size = ListLength(headNode);
        if(position > size || position < 1){
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to "+size);
            return headNode;
        }
        if(position == 1){ //리스트의 가장 첫 앞 삭제
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        }else{ //끝에 닿을 때까지 내부에서 노드 삭제
            ListNode previousNode =headNode;
            int count = 1;
            while(count<position-1){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    //단일 연결 리스트 삭제
    //현재 노드의 값을 임시 변수에 저장하고 현재 노드의 메모리 할당을 해제(Free)
    //시간 복잡도 : 전체크기 n인 리스트 모두 탐색 O(n)
    //공간 복잡도 : 하나의 임시 변수 만듦 O(1)
    void DeleteLinkedList(ListNode head){
        ListNode auxilaryNode, iterator = head;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null; //자바에서 이 부분은 가비지 컬렉터에 의해 관리
            iterator = auxilaryNode;

        }
    }
}
