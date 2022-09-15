'''
Time Complexity - O(N logk)
Space Complexity - O(k)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from queue import PriorityQueue


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        class Merger:
            def __init__(self, node):
                self.node = node

            def __lt__(self, other):
                return self.node.val < other.node.val
        pq = PriorityQueue()
        for head in lists:
            if head:
                pq.put(Merger(head))
        ptr = ListNode(-1)
        curr = ptr
        while not pq.empty():
            node = pq.get().node
            curr.next = ListNode(node.val)
            curr = curr.next
            node = node.next
            if node:
                pq.put(Merger(node))
        return ptr.next
