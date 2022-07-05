""""// Time Complexity : O(nlog(k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

from heapq import heappush as push
from heapq import heappop as pop
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__ = lambda x, y: x.val < y.val
        h = []

        dummy = ListNode(-1)
        temp = dummy

        for i in range(len(lists)):
            curr = lists[i]
            if (curr != None):
                push(h, curr)
        while h:

            minNode = pop(h)

            temp.next = minNode
            if (minNode.next != None):
                push(h, minNode.next)

            temp = temp.next
        return dummy.next


# import heapq
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class CustomComp:
#     def __init__(self, node):
#         self.node = node
#
#     def __lt__(self, other):
#         return self.node.val < other.node.val
#
#
# class Solution:
#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
#         dummy = ListNode(-1)
#         temp = dummy
#         h = []
#         for i in lists:
#             if i is not None:
#                 heapq.heappush(h, CustomComp(i))
#         while h:
#             x = heapq.heappop(h).node
#             temp.next = x
#             temp = x
#             if x.next:
#                 heapq.heappush(h, CustomComp(x.next))
#         return dummy.next


""""// Time Complexity : O(nk)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class Solution:
#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
#         merged = ListNode(float('-inf'))
#         for l in lists:
#             self.merging(merged, l)
#         return merged.next
#
#     def merging(self, l1, l2):
#         result = ListNode(float('-inf'))
#         curr = result
#         curr1 = l1
#         curr2 = l2
#
#         while curr1 and curr2:
#             if curr1.val <= curr2.val:
#                 curr.next = curr1
#                 curr1 = curr1.next
#             else:
#                 curr.next = curr2
#                 curr2 = curr2.next
#             curr = curr.next
#
#         if curr1:
#             curr.next = curr1
#         if curr2:
#             curr.next = curr2
#
#         return result.next
#
#
