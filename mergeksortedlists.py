# Time Complexity : O(NlogK)
# Space Complexity : O(K)
# Did this code successfully run on Leetcode : No, need to figure out how to implement comparater in python
# Any problem you faced while coding this : Yes, Comparator implementation in python

# Your code here along with comments explaining your approach

from heapq import heappush,heappop
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists == None or len(lists) == 0:
            return None
        
        heap = []
        
        for head in lists:
            if head!=None:
                heappush(heap,head)
                
        dummy = ListNode(0)
        cursor = dummy
        
        
        while heap:
            minelement = heappop(heap)
            cursor.next = minelement
            cursor = minelement
            
            if minelement.next!=None:
                heappush(heap,minelement.next)
        
   
        return dummy.next
                
            
            
            
            
        
        
        