'''
// Time Complexity : O(nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        
        for i, node in enumerate(lists):
            if node:
                heappush(heap, (node.val, i, node))
        
        dummy = ListNode()
        cur = dummy
        while heap:
            val, i, node = heapq.heappop(heap)
            cur.next = node
            node = node.next
            cur = cur.next
            if node:
                heappush(heap, (node.val, i, node))
        return dummy.next
  