'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 215. Kth Largest Element in an Array


# https://leetcode.com/problems/kth-largest-element-in-an-array/solution/


#-----------------
# Time Complexity: 
#-----------------
# O(L) - Where L is the length of the key

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pqueue = PriorityQueue()
        head = ListNode(0)
        curr = head
        
        for l in lists:
            if l is not None:
                pqueue.put((l.val, l))
        while not pqueue.empty():
            val, node = pqueue.get()
            curr.next = ListNode(val)
            curr = curr.next
            node = node.next
            if node:
                pqueue.put((node.val, node))
        
        return head.next