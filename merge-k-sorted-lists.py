# TC: O(N logK)
# SC: O(K)

import heapq
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists):
        n = len(lists)
        pq = []
        dummy = ListNode(-1)
        curr = dummy
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(pq, (lists[i].val, i, lists[i]))
        
        while pq:
            val, i, node = heapq.heappop(pq)
            curr.next = node
            curr = curr.next
            if curr.next:
                heapq.heappush(pq, (node.next.val, i, node.next))
        