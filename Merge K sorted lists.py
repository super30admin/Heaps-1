# Time Complexity : O(N*log(k)), N is the total number of elements
# Space Complexity : O(k) for the heap

# The code ran on LeetCode

# Maintain a min heap of size k. The top of the heap always contains the next element to be added to the result linked list. Pop the top element, add it to the result and push the next element if present in the linked list

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        dummy = cur = ListNode(-1)

        heap = []

        for i, l in enumerate(lists):

            if l:
                heappush(heap, (l.val, i))

        while heap:
            val, i = heappop(heap)
            cur.next = ListNode(val)
            if lists[i].next:
                heappush(heap, (lists[i].next.val, i))
                lists[i] = lists[i].next
            cur = cur.next
        return dummy.next