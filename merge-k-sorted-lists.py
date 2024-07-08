# Time Complexity : O(n*mlog(n*m))
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
from typing import List, Optional, ListNode, heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []
        
        # Add all values to the min heap
        for head in lists:
            while head:
                heapq.heappush(minHeap, head.val)
                head = head.next
        
        # Create a new linked list from the min heap
        dummy = ListNode(-1)
        current = dummy
        
        while minHeap:
            current.next = ListNode(heapq.heappop(minHeap))
            current = current.next
        
        return dummy.next