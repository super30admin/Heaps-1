# // Time Complexity : O(n log n)
# // Space Complexity : O(n)

import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []

        for i in lists:

            while(i is not None):
               heapq.heappush(heap,i.val)
               i = i.next
        
       
        if(len(heap)==0):
            return 
        llist = ListNode(None,None)
        llist.val = heapq.heappop(heap)   
        prevNode =  llist

        for i in range(len(heap)):    
            temp = ListNode()
            temp.val = heapq.heappop(heap)
            prevNode.next = temp
            prevNode = prevNode.next  

        return llist     