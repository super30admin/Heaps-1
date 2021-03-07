#TimeComplexity:O(Nlogk) 
#SpaceComplexity: O(N) N is the no of nodes
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__=lambda self,y:self.val<y.val
        
        heap = [node for node in lists if node]
        heapq.heapify(heap)
        dummy=ListNode(0)
        sol=dummy
        while heap:
            cur=heapq.heappop(heap)
            sol.next=cur
            sol=sol.next

            if cur.next:
                heapq.heappush(heap,cur.next)
        return dummy.next