'''
TC: O(nlogk) where k is the number of linked lists 
    and n are the total number of max of the nodes in a linked list
SC: O(k)
'''
# Definition for singly-linked list.
from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        counter = 0
        for li in lists:
            if li:
                heapq.heappush(heap, (li.val,counter,li.next))
                counter+=1
        dummy = ListNode(-1)
        pointer = dummy
        while heap:
            v,_,node = heapq.heappop(heap)
            pointer.next = ListNode(v)
            pointer = pointer.next
            if node:
                heapq.heappush(heap, (node.val, counter, node.next))
                counter += 1
        return dummy.next