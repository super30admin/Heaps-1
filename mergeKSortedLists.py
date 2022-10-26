"""
Approach --
1. Use heapsort.
2. All the elements will be inserted into the heap
3. During insertion heapify will take place and we'll pop the minimum element
Note -- top element will be the smallest element since all the lists are already sorted and we're using min heap
4. After this, when an element is popped, we go to the next element in the list from where the prev element was popped
and will again perform heapify
5. The process will be continued till all the elements in all the lists are visited and the heap becomes empty

TC : O(nklogk) where n is the average number of elements in the array and k is the number lists.
Heapify will take place for k times so logk and it will be performed on all the elements hence nk
SC : O(logk ) where k is the number of lists.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        rtnData = ListNode(None)
        curr = rtnData
        for i, head in enumerate(lists):
            if head:
                heapq.heappush(heap, (head.val, i, head))

        while (heap):
            minVal, minIdx, minNode = heapq.heappop(heap)
            minNext = minNode.next
            minNode.next = None
            curr.next = minNode
            curr = curr.next

            if minNext:
                heapq.heappush(heap, (minNext.val, minIdx, minNext))

        return rtnData.next
