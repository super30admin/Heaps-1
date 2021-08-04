#Time Complexity: O(NKlogK).
#Auxiliary Space: O(K)
#Did this code successfully run on Leetcode :Yes


import heapq
from Queue import PriorityQueue
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        dummy = ListNode(0)
        cur = dummy
        q = []
        # q = PriorityQueue()
        for head in lists:
            if head:
                heapq.heappush(q,(head.val,head))
                # q.put((head.val,head))
        # while not q.empty():
        while q:
            # val,node = q.get()
            val,node = heapq.heappop(q)
            cur.next = node
            cur = cur.next
            if node.next:
                heapq.heappush(q,(node.next.val,node.next))
                # q.put((node.next.val,node.next))
        return dummy.next                