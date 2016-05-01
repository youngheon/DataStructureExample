struct ListNode{
    int data;
    struct ListNode *next;
}
int ListLength(struct ListNode *head){
    struct ListNode *current = head;
    int count=0;
    while(current!=null){
        count++;
        current = current -> next;
    }
    return count;
}
void InsertInLinkedList(struct ListNode **head, int data, int position){
    int k=1;
    struct ListNode *p, *q, *newNode;
    newNdoe = (ListNode *)malloc(sizeof(struct ListNode));
    if(!newNode){
        printf("Memory Error");
        return;
    }
    newNode->data=data;
    p=*head;
    //시작 지점에 삽입
    if(position==1){
        newNode->next=p;
        *head=newNode;
    }
    else{
        //삽입 지점의 위치까지 목록을 탐색
        while((p!=NULL)&&(k<position)){
            k++;
            q=p;
            p=p->next;
        }
        q->next=newNode; //이 작업을 위한 좀 더 최적화함
        newNode->next=p;
    }
}
void DeleteNodeFromLinkedList(struct ListNode **head, int position){
    int k=1;
    struct ListNode *p, *q;
    if(*head==NULL){
        printf("List Empty");
        return;
    }
    p=*head;
    if(position==1){
        //처음
        *head = (*head)->next;
        free(p);
        return;
    }
    else{
        //삭제 위치까지 탐색
        while((p!=NULL)&&(k<position)){
            k++;
            q=p;
            p=p->next;
        }
        if(p==NULL) //끝부분 일경우
            printf(" Position does not exist");
        else{
            q->next = p->next;
            free(p);
        }
    }
}

void DeleteLInkedList(struct ListNode **head){
    struct LIstNode *auxilaryNode, *iterator;
    iterator = *head;
    while(iterator){
        auxilaryNode = iterator->next;
        free(iterator);
        iterator = auxiliaryNode;
    }
    *head = NULL; //호출자의 변수에 반영
    
}