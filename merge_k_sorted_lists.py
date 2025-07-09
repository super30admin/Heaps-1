# Time Complexity : O(N log k), where N is the total number of nodes and k is the number of lists
# Space Complexity : O(log k) for the recursion stack (not counting the output list)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially had to carefully handle merging null/empty lists

# I used a divide and conquer strategy to recursively merge the k sorted lists.
# I kept merging two lists at a time — first merging pairs, then pairs of pairs — until one list remained.
# This is more efficient than a brute-force merge and avoids using extra space like a heap.

from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        return self.mergeRange(lists, 0, len(lists) - 1)

    def mergeRange(self, lists: List[Optional[ListNode]], left: int, right: int) -> Optional[ListNode]:
        if left == right:
            return lists[left]

        mid = (left + right) // 2
        l1 = self.mergeRange(lists, left, mid)
        l2 = self.mergeRange(lists, mid + 1, right)
        return self.mergeTwoLists(l1, l2)

    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        tail = dummy

        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next

        tail.next = l1 if l1 else l2
        return dummy.next
