from queue import PriorityQueue


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = PriorityQueue()
        dummy = ListNode(-1)
        curr = dummy
        for node in lists:
            if node:
                pq.put((node.val, id(node), node))

        while pq.qsize() > 0:
            curr.next = pq.get()[2]
            curr = curr.next
            if curr.next:
                pq.put((curr.next.val, id(curr.next), curr.next))
        return dummy.next
