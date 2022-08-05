# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#time: o(Nlogk)
#space: O(K)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ = lambda x, y: x.val < y.val

        minHeap = []

        result = ListNode(-1)
        curr = result

        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(minHeap, lists[i])
        while (len(minHeap) > 0):
            top = heapq.heappop(minHeap)
            curr.next = top
            if top.next:
                heapq.heappush(minHeap, top.next)
            curr = curr.next
            # curr.next = None

        return result.next