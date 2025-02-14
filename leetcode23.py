# Time Complexity: O(N log k) 
# Space Complexity: O(k)

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

        for i,node in enumerate(lists):
            if node:
                heappush(min_heap,(node.val,i,node))
        dummy = ListNode(-1)
        curr = dummy

        while min_heap:
            val,i,min_node = heappop(min_heap)
            curr.next = min_node
            curr = curr.next

            if min_node.next:
                heappush(min_heap,(min_node.next.val, i, min_node.next))
        return dummy.next