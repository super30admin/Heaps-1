# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#TC: O(NlogN)
#SC: O(N)
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode

        Note: this is Python2 code
        """
        head = point = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, l))
        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next
        
#Merge lists one by one
#TC: O(kN)
#SC: O(1)

class Solution:
    def mergeKLists(self, lists):
        while len(lists) > 1:
            first = lists.pop()
            second = lists.pop()
            new = ListNode()
            temp = new
            while first and second:
                if first.val <= second.val:
                    temp.next = first
                    first = first.next
                else:
                    temp.next = second
                    second = second.next
                temp = temp.next
            while first:
                temp.next = first
                first = first.next
                temp = temp.next
            while second:
                temp.next = second
                second = second.next
                temp = temp.next
            lists.append(new.next)

        return lists[0] if lists else None