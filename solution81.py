#Time Complexity:O(nklogk)
#Space Complexity:O((nk)^2)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import queue as Q
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        merged=ListNode(-inf)
        for li in lists: 							#iterate through the lists one by one and insert the node into merged using the merge function
            merged=self.merge(merged,li)
        return merged.next
    
    def merge(self,l1:ListNode,l2:ListNode)->None:
        dummy=ListNode(-1)
        result=dummy
        while l1 and l2:							#check which niode value is smaller amongst the two and insert the lower value node into merged first
            if l1.val<l2.val:
                dummy.next=l1
                l1=l1.next
            else:
                dummy.next=l2
                l2=l2.next
            dummy=dummy.next						#move to the next node
        if l2:
            dummy.next=l2							#if in either of the lists, any nodes are remining , insert them into merged
        if l1:
            dummy.next=l1
        return result.next