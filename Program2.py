## Problem2

# Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
from typing import List, Optional

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        """
        Time Complexity: O(N log k)
        - N is the total number of nodes across all k lists.
        - k is the number of linked lists.
        - The min-heap contains at most k elements at any given time.
        - Extracting the minimum and inserting a new element into the heap takes O(log k) time.
        - We process exactly N nodes, resulting in N * O(log k) = O(N log k) total time.

        Space Complexity: O(k)
        - The min-heap stores one node from each of the k lists at any time, requiring O(k) extra space.
        - The merged list is built by rearranging existing nodes in place, so no additional space is used for it.
        """
        minheap = []
        
        # Step 1: Initialize the min-heap
        # Iterate through all k lists and push their head nodes into the heap.
        for head in lists:
            if head:
                # We push a tuple of (node.val, id(node), node).
                # 'id(head)' acts as a tie-breaker. If two nodes have the exact same value,
                # heapq will compare the next element in the tuple. Since Python's ListNode 
                # doesn't inherently support comparison operations (like __lt__), comparing 
                # memory addresses via id() prevents a TypeError.
                heapq.heappush(minheap, (head.val, id(head), head))
                
        # Step 2: Set up the dummy head for the merged list
        # A dummy node helps simplify edge cases, avoiding special logic for the first insertion.
        dummy = ListNode()
        
        # 'curr' will be our pointer to build the new merged list
        curr = dummy 
        
        # Step 3: Build the merged list
        while minheap:
            # Pop the node with the absolute smallest current value from the heap
            val, memory, node = heapq.heappop(minheap)
            
            # Attach this smallest node to our merged list
            curr.next = node
            
            # Advance the 'curr' pointer to the new tail
            curr = curr.next
            
            # Step 4: Advance the pointer in the original list
            # If the node we just extracted has a subsequent node in its original list,
            # push that next node into the heap so its value can be evaluated.
            if node.next:
                heapq.heappush(minheap, (node.next.val, id(node.next), node.next))
                
        # The fully merged list starts immediately after our dummy node
        return dummy.next