# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
"""

time - nlogn
space- n to create a HEAP - NOT SURE ( Am i right ?)
"""


import heapq


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        h = []     #list initialized to [] to create a heap
        head = dummy = ListNode(0)   # dummy node
        for l in lists:      # traverse all lists and create heap of n elements with logn height
            while l:
                heapq.heappush(h, l.val)
                l = l.next

        for i in range(len(h)): # pop elements 1 by 1 and create a new merged  list
            dummy.next = ListNode(heapq.heappop(h))
            dummy = dummy.next
        return head.next





