# Time Complexity : O(N log k) where N = total nodes, k = number of lists
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a min-heap to always extract the smallest node among k lists.
# Push the head of each list into the heap as (value, unique_id, node).
# The unique_id (id(node)) is used to avoid comparison issues when values are equal.
# Repeatedly pop the smallest node, attach it to the result list, and
# push its next node into the heap.
# Continue until the heap is empty, resulting in a fully merged sorted list.



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []

        for node in lists:
            if node is not None:
                heapq.heappush(pq,(node.val,id(node),node))

        dummy = ListNode(-1)
        curr = dummy

        while pq:
            val,_,node = heapq.heappop(pq)
            curr.next = node
            curr = curr.next
            if node.next is not None:
                heapq.heappush(pq,(node.next.val,id(node.next),node.next))
        
        return dummy.next

