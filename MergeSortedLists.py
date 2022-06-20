# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


# TC - O(n) - - Doubtful  Please clarify
# SC - O(n) - Doubtful  Please clarify
from Queue import PriorityQueue


class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = ListNode(0)
        pqueue = PriorityQueue()

        if not lists:
            return None

        for node in lists:
            if node:
                pqueue.put((node.val, node.next))

        current = head

        while not pqueue.empty():
            val, node = pqueue.get()
            current.next = ListNode(val)
            current = current.next
            if node:
                pqueue.put((node.val, node.next))

        return head.next
