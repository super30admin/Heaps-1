'''
-- Passed test cases on LeetCode
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    #Brute Force method by using the sort function
    #O(NlogN) - Time complexity as we are using sort function here
    #O(N) - Space complexity to store res array of N elements of the lists.
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        res = []
        head = point = ListNode(0)
        for i in lists:
            while i:
                res.append(i.val)
                i = i.next
        for j in sorted(res):
            point.next = ListNode(j)
            point = point.next
        return head.next
            
        
