"""
Time Complexity : O(nklognk) where k is no. of linked lists and n is average no. of elements
Space Complexity : O(k) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) == 0:
            return None
        pq = []
        # Put the value and list index of the smallest element
        for index, l in enumerate(lists):
            if l:
                heapq.heappush(pq, (l.val, index))
        dummy = curr = ListNode(-1)
        # While my pq is not empty we go through it and pop its minimum element add it         # to the return list if it has a next element, add that to the priority queue           # in its place
        while pq:
            val, minNodeIndex = heapq.heappop(pq)
            minNode = lists[minNodeIndex]
            curr.next = minNode
            if minNode.next:
                # if the next_node has a next node, update the list of linked lists 
                # to point to that node
                lists[minNodeIndex] = minNode.next
                heapq.heappush(pq,(minNode.next.val, minNodeIndex))
            curr = curr.next
        return dummy.next