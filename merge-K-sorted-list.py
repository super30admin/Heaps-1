class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists is None or len(lists) == 0:
            return None
        dummy = ListNode(0)
        res = dummy
        heap = []
        i = 0
        for head in lists:
            if head is not None:
                i += 1
                heapq.heappush(heap, (head.val, i, head))
        while len(heap) > 0:
            _, _, dummy.next = heapq.heappop(heap)
            dummy = dummy.next
            if dummy.next is not None:
                i += 1
                heapq.heappush(heap, (dummy.next.val, i, dummy.next))
        return res.next
