# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
from ast import List
import heapq
from typing import Optional


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap, gidx = [], 0
        dummy= ListNode(0)
        curr = dummy
        
        for head in lists:
            if head:
                heapq.heappush(heap, (head.val, gidx, head))
                gidx += 1

        while heap:
            _, _, minnode = heapq.heappop(heap)
            if minnode.next:
                heapq.heappush(heap, (minnode.next.val, gidx, minnode.next))
                gidx += 1
            minnode.next = None
            curr.next = minnode
            curr = curr.next

        return dummy.next


