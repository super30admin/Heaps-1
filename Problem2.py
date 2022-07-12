'''
Time Complexity: O(kNlog(k)) where k is number of lists and N is average length of lists
Space Complexity: O(k)
Run on Leetcode: YES
'''
import heapq
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    def __le__(self, other) -> bool:
        return self.val < other.val
    
class Solution:
    def mergeKLists(self, lists: list[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0:
            return None
        minHeap = []
        for heads in lists:
            if heads:
                heapq.heappush(minHeap, (heads.val,id(heads), heads))
        
        if len(minHeap) == 0:
            return None
        
        result = ListNode(-1)
        node = result
        while len(minHeap) > 0:
            curr = heapq.heappop(minHeap)[2]
            result.next = curr
            result = result.next
            if curr.next:
                heapq.heappush(minHeap, (curr.next.val, id(curr.next), curr.next))
        return node.next