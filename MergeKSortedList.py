# Definition for singly-linked list.
# Time Complexity - O(nlogn)
# Space Complexity - O(n)
# Solution 1 - Using n size - Min heap 
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
import heapq
class Solution(object):
    def mergeKLists1(self, lists):
        heap = []
        dummy = head = ListNode(None)
        for l in lists:
            while l:
                heapq.heappush(heap, l.val)
                l = l.next
        while heap:
            value = heapq.heappop(heap)
            head.next = ListNode(value)
            head = head.next
        return dummy.next
