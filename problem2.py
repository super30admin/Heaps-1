# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists)==0:
            return None
        queue = []
        ctr = 0
        for i in lists:
            if(i!= None):
                heapq.heappush(queue,(i.val,ctr,i))
            ctr+=1
        dummy = ListNode()
        
        current = dummy
        while(len(queue)!=0):
            val,ctr,curr = heapq.heappop(queue)
            current.next = ListNode(val)
            if(curr.next!=None):
                heapq.heappush(queue,(curr.next.val,ctr, curr.next))
            current = current.next
        return dummy.next   
            
            