# Definition for singly-linked list.
from math import inf
from queue import PriorityQueue


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __lt__(self, other):
        return self.val < other.val


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        """
            https://leetcode.com/problems/merge-k-sorted-lists/
            Time Complexity - O(nk)
                'n' is the number of nodes
                'k' is the number of lists
            Space Complexity - O(1)
            Three lines explanation -
                - Merge two lists at a time
        """
        # edge case
        if not lists:
            return None
        l1 = ListNode(-inf)
        for l2 in lists:
            l1 = self.merge(l1, l2)
        return l1.next

    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(None)
        cur = dummy
        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        if l1:
            cur.next = l1
        if l2:
            cur.next = l2
        return dummy.next

    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        """
            https://leetcode.com/problems/merge-k-sorted-lists/
            Time Complexity - O(nlogk)
                'n' is the number of nodes
                'k' is the number of node lists
            Space Complexity - O(k)
            Three lines explanation -
                - Add k lists to priority queue
                - Get element from priority queue
                - If the cur_min has a next element,
                    add it to the priority queue
        """
        # edge case
        if not lists:
            return None

        pq = PriorityQueue()
        for idx, node in enumerate(lists):
            if node:
                # idx is required to handle case when two
                # val are equal
                pq.put((node.val, idx, node))
        dummy = ListNode(None)
        cur = dummy
        while not pq.empty():
            _, idx, cur_min = pq.get()
            # if there is a next element in the current minimum
            if cur_min.next:
                pq.put((cur_min.next.val, idx, cur_min.next))
            cur.next = cur_min
            cur = cur.next
        return dummy.next
