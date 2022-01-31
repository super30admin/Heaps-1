# Time Complexity : O(Nlog(k)) where N is the number of nodes in all the lists and k is the number of lists
# Space Complexity : O(k) where k is the number of lists (for heap)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        # (value, i, node) added to heap
        # i is needed in python 3 to beak tie between two equal values
        # building a list off all the nodes in lists if they are not none
        heap = [(lists[i].val, i, lists[i]) for i in range(len(lists)) if lists[i]] 
        
        # heapifying them in O(k) time
        heapq.heapify(heap)
       
        head = ListNode(-1)
        curr = head
        
        while heap:  # O(N)
            val, i, node = heapq.heappop(heap) # O(logk)
            curr.next = node
            curr = node
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next)) # O(logk)
        
        # Total = O(N * (2logk)) = O(Nlogk)
        return head.next
            