#이중 연결 리스트
##장점
- 특정 노드로부터 양방향으로 탐색 가능

##단점
- 각 노드가 포인터를 하나 씩 더 필요(저장 공간 더 필요)
- 삽입, 삭제 연산이 더 오래 걸림(포인터 연산이 많아짐)


```java
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
```

```c
struct DLLNode{
    int data;
    struct DLLNode *next;
    struct DLLNode *prev;
};

void DLLInsert(struct DLLNode **head, int data, int position){
    int k=1;
    struct DLLNode *temp, *newNode;
    newNode = (struct DLLNode *) malloc (sizeof(struct DLLNode));
    if(!newNode){ //메모리 체크
        printf("Memorry Error");
        return;
    }
    newNode->data = data;
    if(position ==1){ //시작 위치에 노드를 삽입
        newNode->next = *head;
        newNode->prev = NULL;
        if(*head)
            (*head)->prev = newNode;
        *head = newNode;
        return;
    }
    temp=*head;
    //루프 후, temp는 마지막 노드의 이전 노드를 가리키거나 삽입하고자 하는 위치의 노드가 이전 노드를 가리킴
    while((k<position)&&temp->next!=NULL){
        temp = temp->next;
        k++;
    }
    if(k!=position){
        printf("Desired position does not exist\n");
        
    }
    newNode->next=temp->next;
    newNode->prev=temp;
    if(temp->next)
        temp->next->prev=newNode;
    temp->next=newNode;
    return;
}

void DLLDelete(struct DLLNode **head, int position){
    struct DLLNode *temp, *temp2, temp=*head;
    int k=1;
    if(*head == NULL){
       printf("List is empty");
       return;
    }
    if(position == 1){
        *head = *head->next;
        if(*head!=NULL)
            *head->prev = NULL;
        free(temp);
        return;
    }
    while((k<position-1) && temp->next!=NULL){
        temp = temp->next;
        k++;
    }
    if(k!=position-1){
        printf("Desired position does not exist\n");
    }
    temp2 = temp->prev;
    temp2->next=temp->next;
    if(temp->next) //중간노드 삭제
        temp->next->prev=temp2;
    free(temp);
    return;
    
}
```