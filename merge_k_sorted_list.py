# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # heap method

        heap = []

        for l in lists:
            if l:
                heapq.heappush(heap, (l.val, id(l), l))

        dummy = ListNode(-1)
        curr = dummy

        while heap:
            _, _, node = heapq.heappop(heap)

            curr.next = node
            curr = curr.next

            if node.next:
                heapq.heappush(heap, (node.next.val, id(node.next), node.next))
        return dummy.next


# time complexity is O(nlogk) where n is size of nums
# space complexity is O(k) where k is size of the heap
