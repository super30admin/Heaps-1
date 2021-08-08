# Time Complexity : O(nk logk) Where k is the largest Number
# Space Complexity : O(k)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__ = (lambda a,b : a.val < b.val)

        heap = []
        dummy = ListNode(None, None)
        result = dummy

        for head in lists:
            if head:
                heapq.heappush(heap, head)

        while heap:
            current_smallest = heapq.heappop(heap)
            if current_smallest.next:
                heapq.heappush(heap, current_smallest.next)
            dummy.next = current_smallest
            dummy = dummy.next

        return result.next