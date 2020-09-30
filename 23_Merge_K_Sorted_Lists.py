# Leetcode problem link : https://leetcode.com/problems/merge-k-sorted-lists/
# Time Complexity:    O(nlogk)
# Space Complexity:   O(k)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    Basic approach : Two pointers or merge sort to merge two arrays ata time
    Better approach : Create a min heap of all the integers in the lists by pushing elements of one list at a time and pop at the end for result
    
    Optimized approach : Min heap to keep only head of each list at a time and keep pushing the next element of the popped element
    
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    #  using heap
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return
        
        # custom comparator for list node
        ListNode.__lt__ = lambda x,y : x.val < y.val
        
        # min heap is required to sort in ascending order
        min_heap = []
        
        # push only head nodes
        for head in lists:
            if head != None:
                push(min_heap,head)
        
        dummyHead = ListNode(-1)
        current = dummyHead
        
        while(len(min_heap) > 0):
            min_node = pop(min_heap)
            current.next = min_node
            
            if min_node.next:
                push(min_heap,min_node.next)
            
            current = current.next
        
        return dummyHead.next
            
        
    
    '''
    # merge sort
    def mergeKLists(self, lists):
        # merge list step by step
        # 1. merge [1->4->5] and [1->3-4]. Result = [1->1->3->4->5]
        # 2. merge Result ([1->1->3->4->5]) and last list (2->6)
        if not lists:
            return
        if len(lists) == 1:
            return lists[0]
        mid = len(lists) // 2
        #merge sort. Get the left and right list to mid
        left = self.mergeKLists(lists[:mid])
        right = self.mergeKLists(lists[mid:])
        return self.merge(left, right)
    def merge(self, left, right):
        dummyHead = node = ListNode(-1)
        while left and right:
            if left.val < right.val:
                node.next = left
                left = left.next
            else:
                node.next = right
                right = right.next
            node = node.next
        #if nodes are remaining just point to the list with nodes left
        node.next = left or right
        return dummyHead.next
        '''
        