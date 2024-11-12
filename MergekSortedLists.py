#Time Complexity: O(Nlogk)
#Space Complexity: O(k)
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap=[]
        for i,lis in enumerate(lists):
            if(lis!=None):
                heapq.heappush(heap,(lis.val,i,lis))
        dummy = ListNode(-1)
        curr = dummy
        while(len(heap)>0):
            val, i, currMin = heapq.heappop(heap)
            curr.next = currMin
            curr = curr.next
            if(currMin.next):
                heapq.heappush(heap, (currMin.next.val, i, currMin.next))
        return dummy.next