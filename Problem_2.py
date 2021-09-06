# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    """
    TC - O(nklogk)
    SC - O(nk)
    """
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        ListNode.__lt__ = lambda self, other: self.val < other.val
        pq = []
        for i in lists:
            if i:
                heapq.heappush(pq,i)
        dum = ListNode(-1)
        cur = dum
        while len(pq)>0:
            minelem = heapq.heappop(pq)
            cur.next = minelem
            cur = cur.next
            if minelem:
                minelem = minelem.next
            if minelem:
                heapq.heappush(pq,minelem)
        return dum.next