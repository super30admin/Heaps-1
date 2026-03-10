# Time Complexity : O(N log N), N = total number of nodes across all lists
# Space Complexity : O(N), heap stores all node values
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# We merge k sorted linked lists using a min-heap.
# Steps:
# 1. Traverse all linked lists and push all node values into a min-heap.
# 2. Create a dummy node to simplify list construction.
# 3. Pop values from the heap one by one and create new nodes,
#    linking them to form the merged sorted list.
# 4. Return dummy.next as the head of the merged list.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []
        for i in range(len(lists)):
            while lists[i]:
                heapq.heappush(min_heap,lists[i].val)
                lists[i] = lists[i].next
        dummy = ListNode(0)
        curr = dummy
        while min_heap:
            curr_val = heapq.heappop(min_heap)
            curr.next = ListNode(curr_val)
            curr = curr.next
        return dummy.next

        



        