#Merge k Sorted Lists

# Space -> Ok where n is the number of lists as at any point in time only 1 node from each list is stored in the list
# Time -> N log k where N are total number of nodes across all the list, and logk is the heap sorting every time an elment is poped and pushed back again
# Logic -> since given lists are sorted just keep the starting elements in the list which is a heap to always get the smallest node

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

import heapq
from typing import List, Optional

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []

        for i, list in enumerate(lists):
            if list:
                heapq.heappush(minHeap, (list.val, i, list))
        
        head = ListNode()
        curr = head
        while minHeap:
            val,i, item = heapq.heappop(minHeap)
            curr.next = item
            curr = curr.next
            item = item.next
            if item:
                heapq.heappush(minHeap, (item.val, i, item))
        return head.next
