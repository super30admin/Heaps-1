"Time Complexity is O(N log K)"
"Space Complexity is O(K) for the heap"

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None

        min_heap = []
        dummy = ListNode(-1)
        current = dummy
        
        for i, l in enumerate(lists):
            if l:
                heappush(min_heap,(l.val, i, l))
        
        while(min_heap):
            val, i, node = heappop(min_heap)
            current.next = node
            current = current.next
            if node.next:
                heappush(min_heap, (node.next.val, i, node.next))
        
        return dummy.next

        