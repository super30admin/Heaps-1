# Time Complexity : O(NlogK) 
# Space Complexity : O(K) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
# Approach is to merge k sorted lists by heapifying the initial heads and popping the min from each list then continue heapifying minimum.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def mergeKLists(self, lists):
        res=[]
        heapq.heapify(res)
        k=len(lists)
        for i in range(k):
            if lists[i]:
                temp_val=lists[i].val
                lists[i]=lists[i].next
                heapq.heappush(res, [temp_val,i])
        head=ListNode()
        node=head
        
        while(res):
            v,ind = heapq.heappop(res)
            nd=ListNode(val=v)
            node.next=nd
            node=node.next
            if lists[ind]:
                temp_val=lists[ind].val
                lists[ind]=lists[ind].next
                heapq.heappush(res, [temp_val,ind])
        return head.next