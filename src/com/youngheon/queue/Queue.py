#-*- coding:utf-8 -*-
__author__ = 'Heon'

def Main():
    queue = []
    queue.append(1)
    queue.append(2)
    queue.append(3)
    queue.append(4)

    print queue

    while queue:
        print "Get >" ,queue.pop(0)


Main()


