# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
TC/SC:O(Nlogk)/O(K)
"""
from queue import PriorityQueue

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = curr = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, id(l),l))
        while not q.empty():
            val,id_, node = q.get()
            curr.next = ListNode(val)
            curr = curr.next
            node = node.next
            if node:
                q.put((node.val,id(node), node))
        return head.next
