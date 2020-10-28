"""
Problem: 23. Merge k Sorted Lists
Leetcode: https://leetcode.com/problems/merge-k-sorted-lists/

Basic Approach: Two pointers or merge sort to merge two arrays at a time
Better Approach: Create a min heap of all the integers in the list by pushing elements of one list at a time
    - and pop each element at the end to give result
Optimized Approach: Min heap to keep only head of each list at a time
    - and keep pushing the next element of popped element to heap

Time Complexity: O(N log k), where N is the number of elements in an array, with given kth largest element
Space Complexity: O(k) to store k elements in the heap
Did this code successfully run on Leetcode: Yes
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from heapq import heappush as push
from heapq import heappop as pop


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists or len(lists) is 0:
            return None

        # custom comparator for list node
        ListNode.__lt__ = lambda x, y: x.val < y.val

        # min heap is required to sort in ascending order
        min_heap = []

        # push only head nodes of the lists
        for head in lists:
            if head:
                push(min_heap, head)

        dummy_head = current = ListNode(-1)

        while len(min_heap) > 0:
            min_node = pop(min_heap)
            current.next = min_node

            if min_node.next:
                push(min_heap, min_node.next)

            current = current.next

        return dummy_head.next

