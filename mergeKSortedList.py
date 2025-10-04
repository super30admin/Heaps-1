#Time complexity: O(nk) where n is the length of the list and k is the length of each nodes in the list
#Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The logic here is to merge one list at a time and use the merge sort technique to merge two sorted list and put that back into the result.
# Do it until all the list nodes are merged and then return the result

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        result = ListNode(float("-inf"))
        if not lists: return result.next
        for node in lists:
            result = self.merge(result, node)
        return result.next

    def merge(self, node1, node2):
        re = ListNode(float("-inf"))
        curr = re
        p1 = node1
        p2 = node2
        while (p1 != None and p2 != None):
            if p1.val < p2.val:
                curr.next = p1
                p1 = p1.next
            else:
                curr.next = p2
                p2 = p2.next
            curr = curr.next

        if (p1 != None):
            curr.next = p1
        if p2 != None:
            curr.next = p2

        return re.next

    # Time complexity: O(nlogk)
    # Space Complexity: O(n) using the heap
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

    #The intuition is to put k values in min heap and then remove it and put it in result linked list
    def mergeKListsUsingHeap(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        min_heap = []
        dummy = ListNode(-1)
        result = dummy
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(min_heap, (node.val, i, node))

        dummy = ListNode(-1)
        curr = dummy

        while min_heap:
            val, i, node = heapq.heappop(min_heap)
            curr.next = node
            curr = curr.next
            if node.next != None:
                heapq.heappush(min_heap, (node.next.val, i, node.next))

        return dummy.next