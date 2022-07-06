# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time Complexity: O(nlog(k))
# Space Complexity: O(nlog(k))
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        from heapq import heappush as push
        from heapq import heappop as pop
        heap=[]
        for ll in lists:
            if ll is not None:
                push(heap,ll)
        result=ListNode(-1)
        temp=result
        while len(heap)!=0:
            cur=pop(heap)
            temp.next=cur
            temp=temp.next
            if cur.next != None:
                push(heap,cur.next)
        return result.next