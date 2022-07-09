'''
#TC: O(NlogK)
# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def mergeKLists(self, lists) :
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        #   initialize an empty list which acts as min heap
        minHeapK = []

        #   create a dummy head and start the cursor from that node
        dummyHead = ListNode(-1)
        cursorNode = dummyHead

        #   push into minHeap all head nodes (take care of null checks)
        for i in range(len(lists)):
            currHead = lists[i]
            if (currHead != None):
                push(minHeapK, currHead)

        #   pop min node and add it to the main linked list, and also push its next node into the min heap (if not null)
        while (len(minHeapK) > 0):

            minNode = pop(minHeapK)             #   pop the min node in the heap

            cursorNode.next = minNode
            if (minNode.next != None):          #   push to the heap only if next node exists
                push(minHeapK, minNode.next)

            cursorNode = minNode                #   update cursor node

        #   return dummy head's next node
        return dummyHead.next
'''
#getting error in this code.
# Definition for singly-linked list.
# Definition for singly-linked list.
#TC: O(NK)
class ListNode(object):
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
import sys
minInt=-sys.maxsize-1
class Solution:
    def merge(h1,h2):
        merged1=ListNode(-1)
        curr=merged1
        while(h1!=None and h2!=None):
            if(h1.val<h2.val):
                curr.next=h1
                curr=curr.next
                h1=h1.next
            if(h1.val>=h2.val):
                curr.next=h2
                curr=curr.next
                h2=h2.next
        if h1!=None:
            curr.next=h1
        if h2!=None:
            curr.next=h2
        return merged1.next
         
    
    def mergeKLists(self, lists) :
        
        merged=ListNode(-1)
        for node in lists:
            merged=self.merge(node,merged)
        return merged.next
L1=ListNode(1)
L2=ListNode(2)
L1.next=ListNode(3)
lists=[L1,L2]
Solution.mergeKLists(lists)