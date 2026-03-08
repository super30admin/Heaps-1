''' 
Time Complexity: O(N log k) where N is the total number of nodes in all k lists.
Space Complexity: O(k) for the heap.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []

        for index, childList in enumerate(lists):
            head = childList
            if head:
                heapq.heappush(heap, (head.val, index, head))

        new_head = None
        curr = None
        while heap:
            min_value, index, min_node = heapq.heappop(heap)
            next_node = min_node.next
            if next_node:
                heapq.heappush(heap, (next_node.val, index, next_node))
            if new_head == None:
                new_head = min_node
                curr = new_head
            else:
                curr.next = min_node
                curr = min_node
        return new_head
