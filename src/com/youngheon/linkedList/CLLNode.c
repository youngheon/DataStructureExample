struct CLLNode{
    int data;
    struct ListNode * next;
};


int CircularListLength(struct CLLNode *head){
    struct CLLNode * current = head;
    int count = 0;
    if(head == NULL)
        return 0;
    do{
        current = current -> next;
        count++;
    }while(current!=head);
    return count;
}
void PrintCircularListData(struct CLLNode *head){
    struct CLLNode * current = head;
    if(head ==NULL)
        return;
    do{
        printf("%d",current->data);
        current=current->next;
    }while(current!=head);
}
void InsertAtEndInCLL(struct CLLNode **head, int data){
    struct CLLNode current = *head;
    struct CLLNode *newNode = (struct node*)(malloc(sizeof(struct CLLNode)));
    if(!newNode){
        printf("Memory Error");
        return;
    }
    newNode->data = data;
    while(current->next!=head)
        current = current->next;
    newNode->next = newNode;
    if(*head==NULL)
        *head = newNode;
    else{
        newNode->next=*head;
        current->next= newNode;
    }
}
void InsertAtBiginInCLL(struct CLLNode **head, int data){
    struct CLLNode current = *head;
    struct CLLNode *newNode = (struct node*)(malloc(sizeof(struct CLLNode)));
    
}