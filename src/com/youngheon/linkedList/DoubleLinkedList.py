#-*-coding:utf-8-*-
__author__ = 'Heon'

class DNode:
    def __init__(self, data, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next

def init_dllist():
    global dnode1
    dnode1 = DNode(1)
    dnode2 = DNode(2)
    dnode3 = DNode(3.3333)
    dnode4 = DNode("four")
    dnode1.next = dnode2
    dnode2.prev = dnode1
    dnode2.next = dnode3
    dnode3.prev = dnode2
    dnode3.next = dnode4
    dnode4.prev = dnode3

def delete_dnode(del_data):
    global dnode1
    dnode = dnode1
    while dnode:
        if dnode.data == del_data:
            dnode.prev.next = dnode.next
            dnode.next.prev = dnode.prev
            del dnode
            break
        dnode = dnode.next

def insert_dnode(ins_data):
    global dnode1
    new_dnode = DNode(ins_data)
    new_dnode.next = dnode1
    dnode1.prev = new_dnode
    dnode1 = new_dnode

def print_dllist():
    global dnode1
    dnode = dnode1
    while dnode:
        print dnode.data
        dnode = dnode.next
    print

def Main():
    init_dllist()
    delete_dnode(4)
    insert_dnode(5)
    print_dllist()

Main()