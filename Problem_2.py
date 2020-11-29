"""
Time Complexity : O(nklogk)- where k is the capacity and n is the average length of the list
Space Complexity : O(k) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
here, the basic approach would have been using 2 pointers approach or merging 2 lists at a time.The better
approach id to put all the heads inside a heap. Whichever heap returns lowest value, put its next insid heap
Simultaneously, keep on removing the minimum value from the heap and keep on appending to the list
"""
from heapq import heappush as insert
from heapq import heappop as remove
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return

        ListNode.__lt__ = lambda x, y: x.val < y.val
        heap = []
        for head in lists:
            if head:
                insert(heap, head)
        dummy = ListNode(-1)
        curr = dummy

        while len(heap) > 0:
            node = remove(heap)
            curr.next = node
            if node.next:
                insert(heap, node.next)
            curr = curr.next
        return dummy.next
