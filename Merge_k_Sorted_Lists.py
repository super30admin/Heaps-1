import heapq
from queue import PriorityQueue
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:

        if not lists:
            return
        heap = []
        dummy = ListNode()
        result = dummy
        i = 0
        for list_head in lists:
            if list_head:
                heappush(heap,(list_head.val,i,list_head))
                i+=1
        #print(heap)        
        while len(heap) > 0:
            _, _, min_node = heapq.heappop(heap)
            dummy.next = min_node
            if min_node.next:
                i +=1
                heapq.heappush(heap, (min_node.next.val, i, min_node.next))
            dummy = min_node
        return result.next

