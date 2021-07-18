# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        q = PriorityQueue()
        head = node = ListNode(0,None)
        
        for li in lists:
            if li:
                q.put((li.val,li))
        
        while q.qsize() > 0:
            val,new_node = q.get()
            node.next = new_node
            node = node.next
            if new_node.next is not None:
                q.put((new_node.next.val,new_node.next))
        return head.next
