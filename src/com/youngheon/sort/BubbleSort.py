#-*- coding:utf-8-*-
__author__ = 'Heon'

#http://onestep.tistory.com/44
#가장 느린 알고리즘 (very slow algorithm)

import random

def bubble_sort(random_list):
   for start_index in range( len(random_list)-1 ):
     for index in range( 1, len(random_list) - start_index ):
       if random_list[index-1] > random_list[index]:
         temp = random_list[index-1]
         random_list[index-1] = random_list[index]
         random_list[index] = temp

def Main():
   list = []
   for i in range(10):
     list.append( random.randint(1,10) )

   print "< Before Sort >"
   print list

   bubble_sort(list) # now sorting!
   print "< After Sort >"
   print list

Main()
# o(n^2) spec because of dual for loop
