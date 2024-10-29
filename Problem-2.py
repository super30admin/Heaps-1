#Approach
# take the heap size of K lists and add all the head nodes into the min heap pop the top and make urr as poped element and add curr.next to heap


# complexities
#Time :O(Nlogk)
#Space: O(K)
import heapq
from typing import List, Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []

        for node in lists:
            if node:
                heapq.heappush(heap, (node.val, id(node), node))

        dummy = ListNode(val=float("-inf"))
        curr = dummy
        while heap:
            _, _, currMin = heapq.heappop(heap)
            curr.next = currMin
            curr = curr.next
            if curr.next != None:
                heapq.heappush(heap, (curr.next.val, id(curr.next), curr.next))
        return dummy.next

