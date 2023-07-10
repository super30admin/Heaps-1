"""
Problem : 2

Time Complexity : O(Nklog(k)) //N=size of result linked list
Space Complexity : O(k)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Initializing a min heap with the values of all the head pointers of the K lists
creating the result linked list, and attaching the node with minimum value from heap,
and attaching the next node of the same list inside the heap, so as to get the node with overall minimum value from the heap
returning the result linked list at the end

"""

# Merge k Sorted Lists

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap=[]
        heapq.heapify(heap)
        dummy=ListNode(0)
        curr=dummy
        for head in lists:
            if head:
                heapq.heappush(heap,[head.val,head])

        while heap:
            minVal,minNode=heapq.heappop(heap)
            curr.next=minNode
            curr=curr.next
            if minNode.next:
                heapq.heappush(heap,[minNode.next.val,minNode.next])
        return dummy.next