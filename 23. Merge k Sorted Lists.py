#space: O(no.of lists * size of lists)
#Time: Olog(no.of lists * size of lists)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:   
        heap=list()
        for lst in lists:
            curr= lst
            while curr is not None:
                heapq.heappush(heap,(curr.val, id(curr), curr))
                curr = curr.next
        dummy= ListNode()
        curr= dummy
        while len(heap) != 0:
            _,_,curr.next = heapq.heappop(heap)
            curr = curr.next
        curr.next= None
        return dummy.next
