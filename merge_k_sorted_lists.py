# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# TC: O(N log k) (N = total no of elements, k = no of lists)
# SC: O(k)

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # result LL
        res = ListNode(0)
        head = res
        # build heap of size k where k = # of lists
        # when smallest is popped, add new element of that same list to heap
        # heap stays size k
        heap = []
        for l in range(len(lists)):
            if lists[l] is not None:
                heapq.heappush(heap, (lists[l].val, l))
                lists[l] = lists[l].next
        while heap:
            (val, ind) = heapq.heappop(heap)
            head.next = ListNode(val)
            head = head.next
            if lists[ind]:
                heapq.heappush(heap, (lists[ind].val, ind))
                lists[ind] = lists[ind].next
        return res.next