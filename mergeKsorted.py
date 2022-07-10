#Time complexity: O(N log K)
#Space complexity: O(K)
import heapq as hq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Comparator:
    def __init__(self, node):
        self.node = node
    def __lt__(self, other):
        return self.node.val < other.node.val
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # ListNode.__lt__ = lambda l1,l2: l1.val < l2.val
        res = ListNode()
        curr = res
        pq = []
        for head in lists:
            if head != None:
                hq.heappush(pq, Comparator(head))
        
        while pq:
            minN = hq.heappop(pq).node
            curr.next = minN
            curr = curr.next
            if minN.next != None:
                hq.heappush(pq, Comparator(minN.next))
                
        return res.next
                
                
            
                
            
        
        
        
