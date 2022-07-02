# Time Complexity : O(N log K) where K is number of lists and N is total number of nodes in all lists
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq as hq

# Definition for singly-linked list.
# class ListNode:
#     def __lt__(self, other):
#         return self.val < other.val
    
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

def lt(self, other):
        return self.val < other.val

ListNode.__lt__ = lt

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    
        
        heap = []
        for head in lists:
            if head is not None:
                heap.append(head)
            
        hq.heapify(heap)
        
        result = ListNode(-1)
        curr = result
        while len(heap) > 0:
            currSmallest = hq.heappop(heap)
            
            curr.next = currSmallest
            curr = curr.next
            
            if currSmallest.next is not None:
                hq.heappush(heap, currSmallest.next)
                
        return result.next