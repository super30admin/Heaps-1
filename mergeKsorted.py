#TC - O(NlogK)
#SC - O(N)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i,l in enumerate(lists):
            if l:
                heappush(heap,(l.val,i))
        curr = dummy = ListNode(0)
        while heap:
            val, i = heappop(heap)
            curr.next = ListNode(val)
            if lists[i].next:
                heappush(heap,(lists[i].next.val,i))
                lists[i] = lists[i].next
            curr = curr.next
        return dummy.next

            

        