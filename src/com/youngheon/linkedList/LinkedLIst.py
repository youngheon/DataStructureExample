__author__ = 'Heon'
#-*- coding:utf-8 -*-
class Node:
    def __init__(self, data, next=None):
        self.data = data
        self.next = next



def init_list():
    global node1, node2, node3, node4
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3.3333)
    node4 = Node("four")
    node1.next = node2
    node2.next = node3
    node3.next = node4
    #환형 연결 리스트는  node4.next=node1

def delete_node(del_data):
    global node1
    pre_node = node1
    next_node = pre_node.next

    if pre_node.data==del_data:
        node1 = next.node
        del pre_node
        return

    while next_node:
        if next_node.data==del_data:
            pre_node.next = next_node.next
            del next_node
            break
        pre_node = next_node
        next_node = next_node.next

def insert_node(ins_data):
    global node1
    new_node = Node(ins_data)
    new_node.next = node1
    node1 = new_node

def print_list():
    global node1
    node = node1
    while node:
        print node.data,
        node = node.next
    print

def Main():
    init_list()
    delete_node(2)
    insert_node("new")
    print_list()
#reference document http://onestep.tistory.com/33
Main()

