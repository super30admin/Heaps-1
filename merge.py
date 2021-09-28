#Time Complexity : O(nk log nk) where n is num of linked lists and k is avg length
#Space Complexity : O(nk) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        count = 0
        dummy = ListNode(-1)
        curr = dummy
        if len(lists) == None:
            return pq
        for li in lists:
            if li != None:
                heappush(pq, (li.val, count, li))
                count += 1
        while pq:
            mini = heappop(pq)
            if mini[2].next != None:
                heappush(pq, (mini[2].next.val, count, mini[2].next))
                count += 1
            curr.next = mini[2]
            curr = curr.next        
        return dummy.next