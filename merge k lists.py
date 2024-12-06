# TC: O(Nlogk)
# SC: O(k)
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        setattr(ListNode, "__lt__", lambda a, b: a.val < b.val)
        heap = []
        for head in lists:
            if head:
                heapq.heappush(heap, head)
        
        dummy = ListNode(-1)
        curr = dummy

        while len(heap) != 0:
            node = heapq.heappop(heap)
            curr.next = node
            if node.next:
                heapq.heappush(heap, node.next)
            curr = curr.next
        
        return dummy.next
            
