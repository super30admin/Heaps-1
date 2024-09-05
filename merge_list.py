import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap =[]

        for i in lists:
            if i:
                heapq.heappush(heap,(i.val,id(i),i))
        dummy = ListNode(-1)
        curr = dummy

        while heap:
            _,_,min_node = heapq.heappop(heap)
            curr.next=min_node
            curr = curr.next
            if min_node.next:
                heapq.heappush(heap,(min_node.next.val,id(min_node),min_node.next))
        return dummy.next

        

        