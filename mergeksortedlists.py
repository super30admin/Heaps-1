##Time Complexity : O(nlog(k))
##Space Complexity : O(k)
##Did this code successfully run on Leetcode : Yes
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
        result = root =  ListNode(None)
        for l in lists:
            while l:
                heappush(heap, l.val)
                l = l.next
        while heap:
            result.next = ListNode(heappop(heap))
            result = result.next
        return root.next
        