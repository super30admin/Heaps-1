"""
Time complexity: O(nlogn) We insert n nodes in a heap (logn per insertion)
Space complexity: O(n) where n is the number of lists
Difficulties faced?: No
Compiled on Leetcode?: Yes
"""
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummy = ListNode(None)
        result = dummy
        heap = []
        
        for head in lists:
            if head and (head.val or head.val == 0):
                heapq.heappush(heap, (head.val, id(head), head))
        
        while heap:
            minimum = heapq.heappop(heap)[-1]
            dummy.next = minimum
            if minimum.next:
                heapq.heappush(heap, (minimum.next.val, id(minimum.next), minimum.next))
            dummy = dummy.next    
            
        return result.next  