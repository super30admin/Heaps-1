# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        result = ListNode(float('-inf'))
        
        for lst in lists:
            result = self.merged(result, lst)
        
        return result.next
    
    def merged(self, l1, l2):
        dummy = ListNode(float('-inf'))
        curr = dummy
        
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
            
        if l1 is not None:
            curr.next = l1
        if l2 is not None:
            curr.next = l2
        
        return dummy.next
            
#time complexity is O(nk^2)
#space complexity is O(nk)