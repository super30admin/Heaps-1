# TC : NLogK
# SC : K
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # create a custom comparator for ListNodes
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan

        hq = []

        # create a result head and start the cursor from that node
        result = ListNode(-1)
        cursorNode = result

        # push into minHeap all head nodes
        for i in range(len(lists)):
            currHead = lists[i]
            if (currHead != None):
                heappush(hq, currHead)

        # pop min node and add it to the main linked list, and also push its next node into the min heap (if not null)
        while (len(hq) > 0):
            minNode = heappop(hq)
            cursorNode.next = minNode
            #push to the heap only if next node exists
            if (minNode.next != None):          
                heappush(hq, minNode.next)

            cursorNode = minNode   

        return result.next