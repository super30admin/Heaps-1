# // Time Complexity : O(nk*lgk) where k stands for number of lists and n for length of the longest list
# // Space Complexity : O(nk) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None
        min_heap = []
        count = 1
        for lst in lists:
            head = lst
            while head:
                heapq.heappush(min_heap,(head.val, count, head))
                count += 1
                head = head.next
        
        dummy_head = ListNode(-1)
        cur = dummy_head
        
        while min_heap:
            val, ct, top = heapq.heappop(min_heap)
            cur.next = top
            cur = cur.next
        cur.next = None
        return dummy_head.next
        
            