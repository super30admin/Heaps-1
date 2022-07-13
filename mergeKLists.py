'''
Solution:
1.  To merge k sorted lists, maintain a min heap so that it always maintains k maximum elements at a particular
    point of time and releases min element in those k elements in O(1) operation.
2.  Push into minHeap all head nodes (take care of null checks)
3.  Extract the minNode and move the pointer forward in that corresponding list (take care of null checks)
Time Complexity:    O(n.logk)   |   Space Complexity:   O(k)
'''
from heapq import heappush as hpush
from heapq import heappop as hpop


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #   custom less than comparator using a lambda function taking ListNode objects x and y as parameters
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        #   initialize an empty list which acts as min heap
        minHeap = []

        dummyNode = ListNode(-1)
        cursorNode = dummyNode

        #   push into minHeap all head nodes (take care of null checks)
        for i in range(len(lists)):
            currHead = lists[i]
            if (currHead != None):
                hpush(minHeap, currHead)

        #   pop min node and add it to the main linked list, and also push its next node into the min heap (if not null)
        while minHeap:
            minNode = hpop(minHeap)

            cursorNode.next = minNode

            if (minNode.next != None):
                hpush(minHeap, minNode.next)

            cursorNode = cursorNode.next

        return dummyNode.next












