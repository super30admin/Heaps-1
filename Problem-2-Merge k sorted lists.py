# Definition for singly-linked list.
import heapq
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists) :
        heap = []

        ListNode.__lt__ = (lambda a, b: a.val < b.val)

        for list_node in lists:
            if list_node:
                heapq.heappush(heap, list_node)
        dummy = head = ListNode()

        while heap:
            node = heapq.heappop(heap)
            head.next = node
            head = head.next

            if node.next:
                heapq.heappush(heap, node.next)

        return dummy.next

