"""
    // Time Complexity :T = O(nlogk)
    // Space Complexity :S = O(k)
    // Did this code successfully run on Leetcode : Need to design code as per LC
    // Any problem you faced while coding this : NA
    // Explanation:

    use minimum heap/ priority queue and push all the head of ll
    pop the minimum element from the top of of min heap, update the current pointer
    as the next element of that linked list  

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # edge case
        if lists is None or len(lists) == 0:
            return None
        #custom lambda function
        lessThan = lambda x,y : x.val < y.val
        ListNode.__lt__ = lessThan

        #print(type(lists))
        current = ListNode(-1)
        head = ListNode()
        pq = []
        heapq.heapify(pq)
        result = current

        for head in lists:
            if head is not None:
                heapq.heappush(pq,head)
        #print(pq)
        while pq:
            min = heapq.heappop(pq)
            current.next = min
            current = current.next
            if min.next is not None:
                heapq.heappush(pq,min.next)
        return result.next
