# Time Complexity : O(N log k), where N is the total number of nodes in all the input lists and k is the number of lists
# Space Complexity : O(k), where k is the number of lists

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
from typing import List

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        heap = []
        
        # Push the head of each list to the min-heap
        for i, lst in enumerate(lists):
            if lst:
                heapq.heappush(heap, (lst.val, i))
        
        # Create a dummy node to build the merged list
        dummy = ListNode()
        curr = dummy
        
        # Pop the smallest element from the min-heap and append it to the merged list
        while heap:
            val, idx = heapq.heappop(heap)
            curr.next = ListNode(val)
            curr = curr.next
            
            # Move to the next node in the list at index idx
            lists[idx] = lists[idx].next
            if lists[idx]:
                heapq.heappush(heap, (lists[idx].val, idx))
        
        return dummy.next