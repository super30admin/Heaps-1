"""
TC : O(nklogk) where n is the average length of the lists and k is the number of the lists
SC : O(k) where k is the number of the lists

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution_mergeK:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #lambda argument: expression
        ListNode.__lt__ = lambda self, other: self.val < other.val
        
        pq=[]
        dummy=ListNode(-1,None)
        result=dummy
        for head in lists:
            if head:
                heapq.heappush(pq,head)
        while pq:
            mini=heapq.heappop(pq)
            dummy.next=mini
            dummy=dummy.next
            if mini.next:
                heapq.heappush(pq,mini.next)
        return result.next