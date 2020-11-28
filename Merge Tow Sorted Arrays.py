
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #override the internal function to compare the nodes value


        ListNode.__lt__ = lambda a, b : a.val<b.val
        
        dummy = start = ListNode(0)
        heap = []
        for head in lists:
            if head:
                heapq.heappush(heap, head)
            
        while heap:
            curr = heapq.heappop(heap)
            
            newNode = ListNode(curr.val)
            dummy.next = newNode
            dummy = dummy.next
            curr = curr.next
            if curr:
                heapq.heappush(heap, curr)

        return start.next
    
Time: O(Nlog(K))
Space: K