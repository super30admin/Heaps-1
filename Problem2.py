# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        for idx,head in enumerate(lists):
            if head != None:
                heapq.heappush(pq,(head.val,idx,head))

        dummy = ListNode(-1)
        curr = dummy
        while pq:
            _,idx,minNode = heapq.heappop(pq)
            curr.next = minNode
            curr = curr.next
            if minNode.next:
                heapq.heappush(pq,(minNode.next.val,idx,minNode.next))
        
        return dummy.next


        