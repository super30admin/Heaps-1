
# 23. Merge k Sorted Lists

# Code:

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        res = []
        
        for store in lists:
            elem = store
            while elem:
                heapq.heappush(res, elem.val)
                elem = elem.next
        
        head = dummy = ListNode(0)
        
        while len(res)>0:
            s = heapq.heappop(res)
            
            dummy.next = ListNode(s)
            dummy = dummy.next
        
        return head.next
                

# Time Complexity: O(nlogn)
# Space Complexity: O(N)
# Accepted on Leetcode: Yes