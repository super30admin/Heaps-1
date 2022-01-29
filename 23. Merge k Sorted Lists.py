# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# time complexity: O(nklogk)
# space complexity: O(k)

from heapq import heapify, heappop, heappush
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists==None or len(lists)==0: return None
        
 
        
        heap=[]
        heapify(heap)
        for l in lists:
            ptr=l
            while ptr:
                heappush(heap, ptr.val)
                ptr=ptr.next
                
                
        dummy=ListNode(-1)
        curr=dummy
        
        while(heap):
            node=ListNode(heappop(heap))
            curr.next=node
            curr=curr.next
        
        return dummy.next
        
        
        
#         def merge(l1, l2):
#             dummy=ListNode(-1)
#             curr=dummy
            
#             while(l1!=None and l2!=None):
#                 if l1.val<l2.val:
#                     curr.next=l1
#                     l1=l1.next
#                 else:
#                     curr.next=l2
#                     l2=l2.next
                
#                 curr=curr.next
                
#             if l1!=None:
#                 curr.next=l1
                
#             if l2!=None:
#                 curr.next=l2
                
#             return dummy.next
        
#         dummy=None
#         for l in lists:
#             dummy=merge(dummy, l)
            
#         return dummy
        
        