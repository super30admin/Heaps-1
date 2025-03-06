# https://leetcode.com/problems/kth-largest-element-in-an-array/


# TC: O(n log k): log k for heap of k elements(k lists one ele form each list) for n total numbers
# SC: O(k) : (everytime in heap one element of each list will be there for sure k lists so o(k))
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        for i,head in enumerate(lists):
            if head != None:
                heapq.heappush(pq,(head.val,i,head))
        
        dummy = ListNode(-1)
        curr = dummy

        while pq:
            _,i,minNode = heapq.heappop(pq)
            curr.next = minNode
            curr = curr.next
            if minNode.next is not None:
                heapq.heappush(pq,(minNode.next.val,i,minNode.next))
        
        return dummy.next

