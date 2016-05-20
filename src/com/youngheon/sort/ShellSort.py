#-*-coding:utf-8-*-
__author__ = 'Heon'

#reference by http://onestep.tistory.com/46
#쉘 정렬은 일정 간격 만큼 떨어진 레코드를 삽입 정렬하는 방법

#뛰엄 뛰엄 삽입 정렬을 하고, 간격을 줄여나가면서 삽입 정렬을 반복한다.
#이런 형식으로 정렬을 반복 하게 되면,
# 간격이 줄어들면서 자료 리스트는 대충 정렬되어 있기 때문에 뛰어난 성능보인다.

#쉘 정렬은 그만큼 간격 조정에 따라 효율이 달라진다.

import random

def  shellSort(random_list):
    h = 1
    #find best h
    while h < len(random_list):
        h = h*3+1
    h = h/3

    while h>0:
        for i in range(h):
            # step = h
            #insertion sort start
            start_index=i+h
            while start_index<len(random_list):
                temp=random_list[start_index]
                insert_index=start_index

                while insert_index > h-1 and random_list[insert_index-h] > temp:
                    random_list[insert_index] = random_list[insert_index-h]
                    insert_index=insert_index-h

                random_list[insert_index]=temp
                start_index = start_index+h

            random_list[insert_index] = temp
            start_index = start_index+h
        h=h/3 #set new h

def Main():
    list = []
    for i in range(10):
        list.append(random.randint(1,10))
    print "<Before Sort>"
    print list
    shellSort(list)
    print "<After Sort>"
    print list
Main()
"""
루틴이 조금 복잡해 보인다.
shell_sort()는 처음에 최적의 간격 h를 구하고,
간격을 줄이면서 삽입 정렬을 한다.
간격을 갱신하는 루프 안에 삽입 정렬 루틴이 들어있어 4중 루프문으로 되어있다.
 쉘 정렬은 4중 루프로 되어있어 매우 느릴 것이라고 생각 될 것이지만,
 일반적으로 O(N(logN)^2)이나 O(N^-1.25) 정도의 성능을 가진 것으로 밝혀졌다.
 10,000 이하 자료 집합에서는 다른 O(NlogN) 성능을 가지는 알고리즘보다 오히려 빠를 수가 있다. 추가적인 메모리도 필요 없기 때문에, 10,000이하 자료 집합에서는 쉘 정렬을 사용하는 편이 좋다.
 """
