''''
Time Complexity: O(nklogk)
Space Complexity: O(k)
Executed on Leet: Yes
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        setattr(ListNode, '__lt__',lambda self, other: self.val < other.val)
        
        li = list()
        for i in lists:
            if i:
                heapq.heappush(li,i)
        
        res = ListNode()
        curr = res
        while len(li) != 0:
            mi = heapq.heappop(li)
            curr.next = mi
            curr = curr.next
            if mi.next:
                heapq.heappush(li, mi.next)
        return res.next