# MergeSort
# TC: O(n*k^2) for k lists merge nk elements
# SC: O(1)
# We merge list by list. To Note: starting list- Node("-inf")
# While merging, the min value from each pointer is considered.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists):
        merged = ListNode(float('-inf'))
        for l in lists:
            merged = self.merge(merged, l)       
        return merged.next
    def merge(self, l1, l2):
        dummy = ListNode(-1)
        result = dummy
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                dummy.next = l1
                l1 = l1.next
            else:
                dummy.next = l2
                l2 = l2.next
            dummy = dummy.next
        if l2 != None:
            dummy.next = l2
        if l1 != None:
            dummy.next = l1
        return result.next

# Heap
# TC = O(nk logk)
# SC = O(k)
# heap is used to compare 3 elements from each of the lists. The min is popped each time replaced by new element from respective list until its empty.  
import heapq
class Solution:
    def mergeKLists(self, lists):
        ListNode.__lt__ = (lambda a,b : a.val < b.val)

        heap = []
        dummy = ListNode(None, None)
        result = dummy

        for head in lists:
            if head:
                heapq.heappush(heap, head)

        while heap:
            current_smallest = heapq.heappop(heap)
            if current_smallest.next:
                heapq.heappush(heap, current_smallest.next)
            dummy.next = current_smallest
            dummy = dummy.next

        return result.next