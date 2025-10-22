# Time Complexity: O(k)
# Space Complexity: O(nlogk)
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        heap = []
        for i, node in enumerate(lists): 
            if node: 
                heapq.heappush(heap, (node.val, i, node))

        
        dummy = ListNode(-1)
        curr = dummy

        while heap: 
            _, i, curr_node = heapq.heappop(heap)
            curr.next = curr_node
            curr = curr.next
            if curr_node.next:
                heapq.heappush(heap, (curr_node.next.val, i, curr_node.next))

        return dummy.next
