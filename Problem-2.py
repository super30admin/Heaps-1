from heapq import heappush as push
from heapq import heappop as pop
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        #   initialize an empty list which acts as min heap
        minHeapK = []

        #   create a dummy head and start the cursor from that node
        dummyHead = ListNode(-1)
        cursorNode = dummyHead

        #   push into minHeap all head nodes (take care of null checks)
        for i in range(len(lists)):
            currHead = lists[i]
            if (currHead != None):
                push(minHeapK, currHead)

        #   pop min node and add it to the main linked list, and also push its next node into the min heap (if not null)
        while (len(minHeapK) > 0):

            minNode = pop(minHeapK)             #   pop the min node in the heap

            cursorNode.next = minNode
            if (minNode.next != None):          #   push to the heap only if next node exists
                push(minHeapK, minNode.next)

            cursorNode = minNode                #   update cursor node

        #   return dummy head's next node
        return dummyHead.next