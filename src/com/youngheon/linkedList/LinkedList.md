#3장 연결리스트
##3.1 연결리스트란 무엇인가?
데이터의 집합을 저장하기 위해 사용되는 데이터 구조
- 연속되는 항목들이 포인터로 연결
- 마지막 항목은 NULL을 포인트
- 프로그램이 수행되는 동안 크기가 커지거나 작아질 수 있다.
- (시스템 메모리가 허용하는 한)필요한 만큼 길어질 수 있다.
- 메모리 공간을 낭비하지 않는다. (하지만 포인터를 위한 추가의 메모리를 필요로 한다.)

##3.2 연결리스트 ADT
###연결리스트의 주요 연산
- 삽입: 항목을 리스트에 추가
- 삭제 : 지정된 위치의 항목을 리스트로부터 삭제하며 리턴

###연결리스트의 보조적 연산들
- 리스트 삭제 : 리스트의 모든 항목을 삭제(리스트도 삭제)
- 개수 세기 : 리스트의 항목의 개수를 리턴
- 리스트의 끝으로부터 n번째 항목 찾기 등

##연결 리스트 사용하는 이유 (배열의 단점을 커버치기 위해)
###배열의 개요
배열의 항목에 접근하기 위해서는 항목의 주소가 배열의 기본 주소로부터의 오프셋으로 계산되고 한 번의 곱셈 연산으로 항목의 주소를 구하기 위해 기본주소에 더해져야 할 값이 계산
처음에 데이터형에 따른 항목의 크기가 계산되고, 그것이 항목의 인덱스에 곱해져서 기본 주소에 더해질 값이 된다.
이 과정에 한 번의 곱셈과 한 번의 덧셈이 필요
이 두 연산이 일정한 시간이 걸리므로 배열 접근은 일정한 시간으로 수행
###배열의 장점
간단하고 사용하기 쉽다.
항목에의 접근이 더 빠르다.(일정한 시간이 걸리는 접근)
###배열의 단점
고정된 크기 : 배열의 크기는 정적(사용하기 전에 배열의 크기를 지정)
한 블록의 할당 : 처음에 배열을 할당할 때 전체 배열을 위한 메모리를 얻지 못할 때도 있다.(배열 크기가 클 경우)
복잡한 위치 기반의 삽입 : 주어진 위치에 항목을 삽입하려면 기존의 항목들을 이동해야 할 수 있다. 이렇게 해야 원하는 위치에 새 항목을 추가할 자리가 생기며, 새 항목을 추가할 자리가 가장 앞이면 다른 항목들의 이동 연산이 더욱 오래 걸리게 된다.
###동적배열
동적배열은 랜덤접근하는, 크기가 변하는 리스트 데이터 구조로 새로운 항목들이 추가하거나 삭제 가능
동적 배열을 구현하는 한 가지 간단한 방법은 처음에 일정한 고정된 크기의 배열로 시작하여
배열이 가득 차면 원래 배열의 두 배 크기의 새배열을 만들며, 배열의 항목의 수가 절반이하가 되면 배열 크기의 반으로 새로 생성

##연결리스트의 장점
일정한 시간으로 확장 가능
배열을 만들기 위해서는 특정한 숫자의 항목을 위해 메모리를 할당
배열에 항목을 추가하기 위해서는 새 배열을 만들어 원래 배열에서 새 배열로 항목들을 복사 => 많은 시간 소요
하나의 항목을 위한 공간으로 시작해서 복사나 재할당 없이 새 항목을 쉽게 추가
##연결리스트의 단점
연결리스트의 단점은 개별 항목에 접근하는 접근 시간 많이 소요
배열은 랜덤 접근 가능 (o(1)) & 연속된 메모리에 블록으로 정의되어 배열의 항목은 물리적으로 근처에 위치
마지막 항목이 삭제되면, 가장 끝에서 하자 전의 항목의 포인터가 NULL을 가리키도록 변경 필요 => 탐색이 필요
추가적인 참조 포인터를 위한 메모리 공간이 낭비

##연결 리스트와 배열 그리고 동적 배열의 비교
| 항목 | 연결리스트 | 배열 | 동적배열|
|--------|--------|-----|-----|-----|
|  인덱싱      | O(n)       |O(1)|O(1)
| 가장 앞에 추가/삭제| O(1)|-|O(n)
| 가장 끝에 추가/삭제| O(n)|-|배열이 다 차지 않았을 경우 O(1) 배열이 다 찼을 경우 O(n)
| 중간에 추가/삭제|O(n)|-|o(n)
| 낭비되는 공간|O(n)|0|oO(n)

자바 코드
```java
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
```
C언어.
```
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
```