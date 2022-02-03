# Time Complexity : O(nklogk) where n is the average length of list and k is number of list
# Space Complexity:o(k)
#  Did this code successfully run on Leetcode : Yes

from queue import PriorityQueue


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        curr = dummy

        pq = PriorityQueue()

        for i in range(0, len(lists)):
            if lists[i] is not None:
                pq.put((lists[i].val, i, lists[i]))

        while not pq.empty():
            _, i, minVal = pq.get()
            curr.next = minVal

            if minVal.next is not None:
                pq.put((minVal.next.val, i, minVal.next))

            curr = curr.next

        return dummy.next



