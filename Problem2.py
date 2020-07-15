"""
// Time Complexity : o(knlogkn), k - number of lists, n - nodes in a list
// Space Complexity : o(k) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if not lists:
            return None
        heap = []
        
        for i in lists:
            if not i:
                continue
            heapq.heappush(heap,(i.val,i)) #add values at head and heads of all the k lists
        
        res = res_head = ListNode(-1) #result list
        
        while heap:
            cur_val,node = heapq.heappop(heap) #get first node
            
            new = ListNode(cur_val)
            if node.next: #if next of node exists, add to heap
                heapq.heappush(heap,(node.next.val,node.next))
            res.next = new #move pointers
            res = res.next
        return res_head.next
        
        
        