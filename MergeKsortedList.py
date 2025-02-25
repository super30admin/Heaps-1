# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#*******************Must watch Lecture*******************-------------------
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        curr = dummy
        heap = []

        for l in lists:
            if l:
                heapq.heappush(heap, (l.val, id(l), l))

        while heap:
            val, add, MinNode = heapq.heappop(heap)
            curr.next = MinNode
            curr = curr.next
            if MinNode.next:
                heapq.heappush(heap, (MinNode.next.val, id(MinNode.next), MinNode.next))
        
        return dummy.next
        