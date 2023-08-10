#Time Complexity :O(nlogk)
#Space Complexity :O(n+k) where k is the number of linked list and n is the no of nodes
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap=[]
        for head in lists:
            while head:
                heapq.heappush(heap,head.val)
                head=head.next
        
        curr=ListNode(-1)
        dummy=curr
        while heap:
            curr.next=ListNode(heapq.heappop(heap))
            curr=curr.next

        return dummy.next
