#-*- coding:utf-8 -*-
__author__ = 'Heon'
import random
## basic python API
list = []
for i in range(10):
    list.append(random.randint(1,10))

print ("<Before Sort>")
print list
print list.sort()
print ("<After Sort>")
print list

############################HardCoding###############################


def selected_sort(random_list):
  for sel in range( len(random_list)-1 ):
    min = random_list[sel]
    minindex = sel
    # find min value
    for step in range( sel+1, len(random_list) ): #find differ from next value
      if min > random_list[step]:
        min = random_list[step]
        minindex = step
    # swap
    random_list[minindex] = random_list[sel]
    random_list[sel] = min


def Main():
  list2 = []
  for i in range(10):
    list2.append( random.randint(1,10) )
  print "< Before Sort >"
  print list2

  selected_sort(list2) # now sorting!
  print "< After Sort >"
  print list2

Main()

# n^2 spec