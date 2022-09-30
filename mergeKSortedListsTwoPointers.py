"""
Time Complexity : O(n*k^2) where n is the average number of elements in the lists and k is the number of lists
                  nk will be the time complexity to iterate through all the elements for merging and sorting 
                  and this needs to be done on the k lists.
Space Complexity : O(1) no new auxillary data structure is use

Did this code successfully run on Leetcode : No, Time Limit Exceeded
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Idea here is to merge and sort two lists at a time. Again merge the thord list with the already merged list and performed sorting.
For sorting two pointers are used.
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def merged(self, head1, head2):
        head = ListNode(-1)
        curr = head
        while(head1 != None and head2 != None):
            if head1.val < head2.val:
                curr.next = head1
                head1 = head1.next
            else:
                curr.next = head2
                head2 = head2.next
            curr = curr.next
        
        while head1 != None:
            curr.next = head1
            head1 = head1.next
            curr = curr.next
        
        while head2 != None:
            curr.next = head2
            head2 = head2.next
            curr = curr.next
        
        return head.next
                
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        merged = ListNode(float('-inf'))
        for i, liList in enumerate(lists):
            if liList:
                merged = self.merged(merged, liList)
        
        return merged.next

        