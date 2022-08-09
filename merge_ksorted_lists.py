# Time complexity: O(nk log k)
# space complexity: O(k)
# Approach: create a minheap of size k- no.of.lists
# pop the root of minheap and push the popped elements next



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        heap = []
        dummy = ListNode(-1)
        curr = dummy
        for i in range(len(lists)):
            if lists[i]!= None:
                push(heap,lists[i])
        while heap:
            minnode = pop(heap)
            curr.next = minnode
            if minnode.next != None:
                push(heap, minnode.next)
            curr = curr.next
        return dummy.next
        
        
       
            
                
            
        