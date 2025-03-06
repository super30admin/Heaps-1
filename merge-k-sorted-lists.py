# Time Complexity : O(Nlogk) - N is the total number of elements in all the lists
# Space Complexity : O(k) - for heap
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Use min heap of size K to store the first node element of K lists
Then take the min and add it to the result linked list and push the next of the min to the heap
Continue doing this until there are nodes in the heap
"""
import heapq


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class HeapNode:
    def __init__(self, node):
        self.node = node

    def __lt__(self ,other):
        return self.node.val < other.node.val

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(-1)
        current = dummy
        heap = []

        for list in lists:
            if list:
                heapq.heappush(heap, HeapNode(list))

        while heap:
            node = heapq.heappop(heap).node
            current.next = node
            current = current.next
            if node.next:
                heapq.heappush(heap, HeapNode(node.next))

        return dummy.next

