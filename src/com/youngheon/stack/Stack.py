#-*- coding:utf-8-*-
__author__ = 'Heon'
def Main():
    stack=[]  # stack 생성
    stack.append(1)
    stack.append(2)
    stack.append(3)
    stack.append(4)
    print stack

    while stack:
        print "POP > ", stack.pop()

Main()





