"""
Runtime Complexity:
O(N logk) - where 'N' is nk. k lists with average of length 'n' and we push and pop log k levels from priority queue
Space Complexity: O(k) - priority queue space which will hold k elements not all the elements because we perform push and pop continuously till we make our final result list.
Yes, the code worked on leetcode.
Issues while coding - No.
"""
from Queue import PriorityQueue
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        head = point = ListNode(0)
        q = PriorityQueue()
        for l in lists:
            if l:
                q.put((l.val, l))       
        while not q.empty():
            val, node = q.get()
            point.next = ListNode(val)
            point = point.next
            node = node.next
            if node:
                q.put((node.val, node))
        return head.next