#-*-coding:utf-8-*-
__author__ = 'Heon'
#http://onestep.tistory.com/45

import random
def insertion_sort(random_list):
    random_list.insert(0,-1)
    for start_index in range(2,len(random_list)):
        temp = random_list[start_index]
        insert_index=start_index

        #insert index search
        while random_list[insert_index-1] > temp:
            random_list[insert_index] = random_list[insert_index-1]
            insert_index=insert_index-1

        random_list[insert_index]=temp
    del random_list[0]
"""가장 앞에 -1 이라는 원소를 추가했다가 삭제하는 이유는 while문의 조건을 하나로 하기 위함이다. 이런 루틴이 없으면 insert_index가 0보다 큰지도 판별 해야 한다. 이렇게 임시로 값을 넣어서 조건문을 하나 줄이는 기법을 보초 기법 이라고 한다.
 현재 구현된 삽입 정렬은 삽입 될 위치를 찾을 때 앞에서 부터 차례대로 찾는 순차 검색을 한다. 검색법 중에 이분 검색을 이용 하면 삽입 할 위치를 빠른 속도로 찾을 수 있다. 삽입 정렬은 이중 루프문으로 구성 되어있기 때문에 O(N^2)의 성능을 가진다."""


def Main():
    list = []
    for i in range(10):
        list.append(random.randint(1,10))
    print "<Before Sort>"
    print list
    insertion_sort(list) # now sorting
    print "<After Sort>"
    print list

Main()

# spec is O(n^2)
