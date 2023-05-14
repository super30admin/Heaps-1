# Time Complexity: O(nlogk)
# Space Complexity: O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The k sorted arrays are merged by using a minheap of size k. We iterate through the lists and push the first 
element of each list into the heap. After which we pop the min element from the heap and add it to the result. 
We then push the next element of the list from which the min element was popped. We continue this process until 
the heap is empty.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if lists = None or len(lists) == 0: return None

        pq = heapq 
        li = []

        for l in lists:
            if l:
                pq.heappush(li, (l.val, l))

        while len(pq) > 0:
            val, Min = pq.heappop(li)
            curr.next = Min
            if Min.next != None:
                pq.heappush(li, )