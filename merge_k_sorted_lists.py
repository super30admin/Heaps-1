# O(N * LOG(K)) TIME AND O(N) SPACE

from collections import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        head = ListNode(0)
        current = head
        heap = []
        for i,li in enumerate(lists):
            if li:
                heapq.heappush(heap,(li.val,i,li))
        
        while heap:
            val,idx,node = heapq.heappop(heap)
            current.next = ListNode(val)
            current = current.next
            node = node.next
            if node is None:
                continue
            heapq.heappush(heap,(node.val,idx,node))
        return head.next