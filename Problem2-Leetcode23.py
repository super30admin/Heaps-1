#Time Complexity: O(n log k) where n is the total number of nodes in all lists and k is the number of linked lists
#Space Complexity: O(k) where k is the number of linked lists

import heapq
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        pq = []
        for i, node in enumerate(lists):
            if node is not None:
                heapq.heappush(pq, (node.val, node))

        dummy = ListNode(-1)
        curr = dummy

        while pq:
            val, min_node = heapq.heappop(pq)
            curr.next = min_node
            curr = curr.next
            if min_node.next is not None:
                heapq.heappush(pq, (min_node.next.val, min_node.next))

        return dummy.next
        