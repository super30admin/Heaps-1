#TC: O(n.logk)
#SC: O(k)

from heapq import heappush as push
from heapq import heappop as pop

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class MergeKLists:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:

        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        minHeapK = []

        dummyHead = ListNode(-1)
        cursorNode = dummyHead

        for i in range(len(lists)):
            currHead = lists[i]
            if (currHead != None):
                push(minHeapK, currHead)

        while (len(minHeapK) > 0):

            minNode = pop(minHeapK)         

            cursorNode.next = minNode
            if (minNode.next != None):      
                push(minHeapK, minNode.next)

            cursorNode = minNode              