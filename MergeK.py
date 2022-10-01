#Time: O(nklogk)
#Space: O(k)
# where n is the number of lists, k is the average number of elements per list
#Program ran on leetcode successfully

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        pq = []
        for head in lists:
            if head is not None:
                heapq.heappush(pq, (head.val, head))
            
        result = ListNode(-1)
        curr = result
        while pq:
            min_num = heapq.heappop(pq)[1]
            curr.next = min_num
            curr = curr.next
            if (min_num.next is not None):
                heapq.heappush(pq, (min_num.next.val, min_num.next))
            
        return result.next
            
            