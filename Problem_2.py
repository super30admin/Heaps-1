# Definition for singly-linked list.
import heapq


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists):
        head = ListNode(-1)
        curr = head
        pq = []
        for idx, li in enumerate(lists):
            if li:
                heapq.heappush(pq, (li.val, idx, li))

        while pq:
            value, idx, top = heapq.heappop(pq)
            curr.next = top
            if top.next:
                nextNode = top.next
                heapq.heappush(pq, (nextNode.val, idx, nextNode))
            curr = curr.next
        return head.next
