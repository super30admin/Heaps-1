'''
Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]: # type: ignore
        dummy = ListNode(-1) # type: ignore
        current = dummy
        heap = []

        for l in lists:
            if l:
                heapq.heappush(heap, (l.val, id(l), l)) # type: ignore
                #l.val = val of node for sorting
                #id(l) = memory address of node(tie - breaker)
                #l = actual node object

        while heap:
            val, mem, node = heapq.heappop(heap) # type: ignore
            current.next = node
            current = current.next

            if node.next:
                heapq.heappush(heap, (node.next.val, id(node.next), node.next))         # type: ignore
        return dummy.next        