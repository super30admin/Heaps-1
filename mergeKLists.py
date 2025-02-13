# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    # TC : O(k)
    # SC : O(k)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i,node in enumerate(lists):
            if node:
                heapq.heappush(heap,(node.val,i,node))
        res = ListNode(-1)
        cur = res
        while heap:
            val,i,node = heapq.heappop(heap)
            cur.next = node
            node = node.next
            cur = cur.next
            if node :
                heapq.heappush(heap,(node.val,i,node))
        return res.next