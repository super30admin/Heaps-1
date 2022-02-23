# Time Complexity : O(Nlog(k)) where N is the number of nodes in all the lists and k is the number of lists
# Space Complexity : O(k) where k is the number of lists (for heap)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = [(lists[i].val, i, lists[i]) for i in range(len(lists)) if lists[i]] 
        heapq.heapify(heap)
       
        head = ListNode(-1)
        curr = head
        
        while heap:  
            val, i, node = heapq.heappop(heap) 
            curr.next = node
            curr = node
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next)) 
        return head.next
            