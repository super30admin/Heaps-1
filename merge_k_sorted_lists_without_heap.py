# Time Complexity : O(K^2 * n) where K is number of lists and n is average number of node in a list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        merged = ListNode(float('-inf'))
        
        for li in lists:
            merged = self.mergeLists(merged, li)
            
        return merged.next
    
    def mergeLists(self, li1, li2):
        result = ListNode(float('-inf'))
        curr = result
        while li1 is not None and li2 is not None:
            if li1.val < li2.val:
                curr.next = li1
                li1 = li1.next
            else:
                curr.next = li2
                li2 = li2.next
            curr = curr.next
            
        if li1 is not None:
            curr.next = li1
        if li2 is not None:
            curr.next = li2
            
        return result.next