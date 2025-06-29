#Time Complexity: O(nlogk)
#Space Complexity: O(K)

import heapq
# # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[Optional[ListNode]]
        :rtype: Optional[ListNode]
        """
        
        min_heap = []

        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(min_heap,(lists[i].val,lists[i])) 

        dummy = ListNode(0)
        current = dummy

        while min_heap:
            val,node = heapq.heappop(min_heap)
            current.next = node
            current = current.next

            if node.next:
                heapq.heappush(min_heap, (node.next.val, node.next))
        
        return dummy.next

