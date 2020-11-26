# Time Complexity: O(n log k)
# Space Complexity: O(k)
# Approach: Add the heads of all lists to a minheap. Pop out the min element and add the next element from the corresponding list to the heap. 

from heapq import *
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # Initialize a minheap
        minheap = []
        
        # Push the heads of all lists in the heap
        for root in lists:
            if root:
                heappush(minheap, (root.val, root))
        
        # Head and tail for new list
        head, tail = None, None
        
        # Pop out smallest element, push the next smallest from that list in the heap 
        while minheap:
            val, node = heappop(minheap)
            if head is None:
                head = tail = node
            else:
                tail.next = node
                tail = tail.next
            # Push the next smallest element 
            if node.next:
                heappush(minheap, (node.next.val, node.next))
                
        return head