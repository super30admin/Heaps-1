# Time Complexity: O(nk^2) second - O(nk log nk)
# Space Complexity: O(nk) second - O(1) 
import heapq
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
        stack = []        
        for i, v in enumerate(lists):
            while v:
                heapq.heappush(stack, (v.val))
                v = v.next
        print(stack)
        head = ListNode(None)
        curr = head
        while stack:
            v = heapq.heappop(stack)
            temp = ListNode(v)
            curr.next = temp
            curr = temp
            
        return(head.next)
#         stack = []
#         head = ListNode(None)

#         curr = head
#         for i, v in enumerate(lists):
#             if lists[i]:
#                 heapq.heappush(stack,(v.val, i))

#         while stack:
#             v, i = heapq.heappop(stack)
#             temp2 = ListNode(v)
#             head.next = temp2
#             head = temp2
#             lists[i] = lists[i].next
#             if lists[i] == None:
#                 continue
#             heapq.heappush(stack, (lists[i].val, i))
#         return curr.next