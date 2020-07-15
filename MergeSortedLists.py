-------------------------------- Merge K sorted lists ---------------------------------------------
# Time Complexity : nk^2
# Space Complexity : O(nk)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have iterated through lists and added all head elements to heap. Created a dummy node of res and iterate through heap.
# pop the min element and add as the next node in the resultant list. If the pop node has next element append that node to heap.
# Continue the same process untill we dont have any elements in the lists.




# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists:
            return None
        
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        
        heap = []
        for head in lists:
            if head != None:
                heapq.heappush(heap, head)
        
        res = ListNode(-1)
        curr = res
        while heap:
            temp = heapq.heappop(heap)
            curr.next = temp
            temp = temp.next
            if temp != None:
                heapq.heappush(heap, temp)
            curr = curr.next
        return res.next