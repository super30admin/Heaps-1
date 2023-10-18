# Time Complexity: O(nmlog(n)) where n is length of lists and m is the avg number of elemets in the linkedlist.
#  Space Complexity:  O(n).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, : List[Optional[ListNode]]) -> Optional[ListNode]:
        ListNode.__lt__ = lambda o1, o2: o1.val < o2.val
        if lists == None or len(lists) == 0: 
            return None
        li =[]
        heapq.heapify(li)
        for head in lists:
            if head != None:
                # t = (head.val, head)
                # heapq.heappush(li, t)
                heapq.heappush(li, head)
        result = ListNode(-1)
        curr = result
        while li:
            # val, node = heapq.heappop(li)
            node = heapq.heappop(li)
            if node.next:
                # heapq.heappush(li, (node.next.val, node.next))
                 heapq.heappush(li, node.next)
            curr.next = node
            curr = curr.next
        return result.next
