# Time Complexity: O(n * log(k))
# Space Complexity: O(k)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        dummyNode = ListNode(0)
        curr = dummyNode
        while heap:
            (val, index) = heapq.heappop(heap)
            curr.next = lists[index]
            curr = curr.next
            lists[index] = lists[index].next
            if lists[index]:
                heapq.heappush(heap, (lists[index].val, index))
        return dummyNode.next