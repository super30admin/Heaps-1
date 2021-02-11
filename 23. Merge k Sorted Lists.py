# T = O(nlogk)
# S = O(k)
# Approach:
# Store the heads of every list in a min heap
# pop the element that is smaller and move the pointer of the list to the next one
# do it untill all the lists are traversed. The every pop fom the heap will give the 
# smallest element in order.

from heapq import heappush as insert
from heapq import heappop as remove
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return
        
        ListNode.__lt__ = lambda x, y: x.val < y.val
        heap = []
        for head in lists:
            if head:
                insert(heap, head)
        dummy = ListNode(-1)
        curr = dummy

        while len(heap) > 0:
            node = remove(heap)
            curr.next = node
            if node.next:
                insert(heap, node.next)
            curr = curr.next
        return dummy.next