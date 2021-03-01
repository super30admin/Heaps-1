# NlogK TIME AND N SPACE WHERE N IS TOTAL NO.OF NODES AND K IS NO.OF LISTS
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
from collections import heapq
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
            current.next = node
            current = current.next
            node = node.next
            if node is None:
                continue
            heapq.heappush(heap,(node.val,idx,node))
        return head.next