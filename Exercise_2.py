# ## Problem2
# Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
# // Time Complexity : O(nklogk)
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Definition for singly-linked list.
from heapq import heappush as insert
from heapq import heappop as remove


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists):
        # dummy node
        node = ListNode(None)
        # Priority Queue
        pq = []
        # Adding all elements from the list to pq
        for i in range(len(lists)):
            if lists[i]:
                # adding listNode and its position
                insert(pq, (lists[i].val, i))
                # pointing to next
                lists[i] = lists[i].next
        # iterating over the pq
        while pq:
            # popping the min from pq
            val, i = remove(pq)
            curr.next = ListNode(val)
            # incrementing the ptr to point to next
            curr = curr.next
            if lists[i]:
                insert(pq, (lists[i].val, i))
                lists[i] = lists[i].next
        return node.next
