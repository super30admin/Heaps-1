# // Time Complexity : O(nk log(k))
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We use Proority queue : MIN HEAP
# we put the heads of all lists into heap, it will heapify
# we pop and append to the resultant list
# while heap is not null we keep pushing and popping and appending
# min element from the all list will be popped out hence only that lists pointer will be moved to next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if lists is None or lists == []: return
        from heapq import heappush, heappop

        ListNode.__lt__ =  lambda x,y : x.val<y.val
        heap = []
        dummy = ListNode(-1)
        res = dummy
        # push heads of all the lists into heap
        for head in lists:
            if head:
                heappush(heap, head)
        
        while heap:
            # remove the minimum node
            minNode = heappop(heap)
            # attach that to the dummy node
            dummy.next = minNode
            # move pointer of that minNode to next as we have used that
            if minNode.next:
                heappush(heap, minNode.next)
            # move dummy to next
            dummy = dummy.next
        
        return res.next
            
            

#         dummy = ListNode(float('-inf'))
#         merged = dummy
#         for l in lists:
#             merged = self.merge(merged, l)
        
#         return merged.next
        
#     def merge(self,l1,l2):
        
#         dummy = ListNode(-1)
#         res = dummy
#         while l1 and l2:
            
#             if l1.val<l2.val:
#                 dummy.next = l1
#                 l1 = l1.next
#             else:
#                 dummy.next = l2
#                 l2 = l2.next
#             dummy = dummy.next
        
#         if l1:
#             dummy.next = l1
        
        
#         if l2:
#             dummy.next = l2
        
#         return res.next
                      
        
        