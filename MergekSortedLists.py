# Time Complexity : O(nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We put the first node of every list into a min-heap.
# Each time we pull out the smallest node and add its next to the heap.
# That way, we're always getting the next smallest node to our merged list.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class HeapNode:
    def __init__(self, node):
        self.node = node

    def __lt__(self, other):
        return self.node.val < other.node.val

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        for l in lists:
            if l is not None:
                heapq.heappush(pq, HeapNode(l))
        
        dummy = ListNode(-1)
        curr = dummy

        while pq:
            min_node = heapq.heappop(pq).node
            curr.next = min_node
            curr = curr.next
            if min_node.next is not None:
                heapq.heappush(pq, HeapNode(min_node.next))

        return dummy.next
        
        