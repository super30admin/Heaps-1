#Time Complexity :O(nklogk) n is elements in one list (nk total elements)
#Space Complexity :O(k) k is len(list) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ListNode.__lt__ = (lambda a, b : a.val < b.val)
        heap=[]
        
        dummy=ListNode(-1)
        result=dummy
       
        for i in lists:
            if i:
                heappush(heap,i)
            
        while(heap):
            curr=heappop(heap)
            dummy.next=curr
            dummy=dummy.next
            if(curr.next):
                heapq.heappush(heap,curr.next)
        return result.next