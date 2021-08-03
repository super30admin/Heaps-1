# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class abc:
    def __lt__(self,other):
        return self.val<other.val
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
            ListNode.__lt__=abc.__lt__
            h=[]
            for i in lists:
                if i:
                    heapq.heappush(h,i)
            dummy=head=ListNode(-1)
            while h:
                node=heapq.heappop(h)
                head.next=node
                head=head.next
                if node.next:
                    heapq.heappush(h,node.next)
            return dummy.next
            