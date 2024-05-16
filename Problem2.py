## Problem2

# Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

# Approach
# Import heapq. Traverse through the list and add node.val, index and node as tuple to heap.
# Create new Linked List. Pop top node from heap and point head -> popped node from head. set curr = curr.next
# if currMin != None, increment index and add currMin.next.val,index and currMin.next node to heap. Continue till heap is not empty. return head.next


# Time Complexity: O(Nlogk)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq as hq

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for li in range(len(lists)):
            if lists[li]:
                hq.heappush(heap, (lists[li].val, li, lists[li]))
        # print(heap)
        
        head = ListNode(0)
        curr = head

        while heap:
            currMin = hq.heappop(heap)
            currMin = currMin[2]
            curr.next = currMin
            curr = curr.next
            if(currMin.next != None):
                li += 1
                hq.heappush(heap,(currMin.next.val,li,currMin.next))
        return head.next
        