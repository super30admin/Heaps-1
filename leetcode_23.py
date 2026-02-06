class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        count = 0   

        # push first node of each list
        for node in lists:
            if node:
                heapq.heappush(heap, (node.val, count, node))
                count += 1

        dummy = ListNode(0)
        curr = dummy

        while heap:
            _, _, node = heapq.heappop(heap)
            curr.next = node
            curr = curr.next

            if node.next:
                heapq.heappush(heap, (node.next.val, count, node.next))
                count += 1

        return dummy.next