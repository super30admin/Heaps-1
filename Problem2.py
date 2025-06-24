"""
I implemented the solution using the min-heap technique.
I inserted all the elements from every linked list into the min-heap.
Then, I created a dummy node and repeatedly popped the smallest element from the min-heap to construct a new sorted linked list.
Time Complexity:O(nmlog(nm))
Space Complexity:O(nm)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minHeap = []
        for head in lists:
            while head:
                heapq.heappush(minHeap, head.val)
                head = head.next
        dummy = ListNode(-1)
        current = dummy

        while minHeap:
            current.next = ListNode(heapq.heappop(minHeap))
            current = current.next
            
        return dummy.next