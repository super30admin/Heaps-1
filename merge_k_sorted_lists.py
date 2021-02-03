# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Time Complexity: O(nk log(k))
# Space Complexity: O(k)

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        ListNode.__lt__ = (lambda a,b : a.val < b.val)
        
        heap = []
        dummy = ListNode(None, None)
        result = dummy
        
        for head in lists:
            if head:
                heappush(heap, head)
        
        while heap:
            current_smallest = heappop(heap)
            if current_smallest.next:
                heappush(heap, current_smallest.next)
            dummy.next = current_smallest
            dummy = dummy.next
        
        return result.next