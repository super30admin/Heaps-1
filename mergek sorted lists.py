# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        heap=[]

        for i, head in enumerate(lists):
            if head:
                heapq.heappush(heap,(head.val,i,head))
        dummy=ListNode(0)
        curr=dummy
        while heap:

            val,i, min_node=heapq.heappop(heap)
            curr.next=min_node
            curr=curr.next
            if min_node.next is not None:
                heapq.heappush(heap,(min_node.next.val,i,min_node.next))
        return dummy.next
        