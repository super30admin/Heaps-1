# time - O(nklogk)
# space- O(n)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from queue import PriorityQueue


class use_only_first:
    def __init__(self, first, second):
        self._first, self._second = first, second

    def __lt__(self, other):
        return self._first < other._first


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:

        # q=PriorityQueue()
        # head=temp=ListNode(0)
        # for l in lists:
        #     if l:
        #         q.put((l.val,l))
        # while len(q)>0:
        #     use_object = q.get()
        #     val = use_object._first
        #     node = use_object._second
        #     head.next=ListNode(val)
        #     head=head.next
        #     node=node.next
        #     if node:
        #         q.put(use_only_first(node.val,node))
        # return temp.next
        from heapq import heappush
        from heapq import heappop
        heap = []
        ListNode.__lt__ = lambda x, y: x.val < y.val
        head = temp = ListNode(0)
        for l in lists:
            if l:
                heappush(heap, l)
        while len(heap) > 0:
            node = heappop(heap)
            head.next = node
            node = node.next
            head = head.next
            if node:
                heappush(heap, node)
        return temp.next
