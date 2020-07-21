import heapq
# O(nklogk)
# O(n)
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __lt__(self, l2):
        return self.val < l2.val

class Solution(object):
    # Time Complexity : O(n*log(n)), where n is the combined length of all the lists
    # Space Complexity : O(n), heap space used.
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a min heap to preserve order,
    # pushes all list nodes, uses lt def to preserve order.
    # The nodes are then popped and relinked to form the result.
    def mergeKLists(self, lists):
        # if empty
        if not lists:
            return None
        # if only one sorted list exists
        if len(lists) == 1:
            return lists[0]

        pQueue = []
        for i in lists:
            temp = i
            while temp != None:
                heapq.heappush(pQueue, temp)
                temp = temp.next

        prev = ListNode(-1)
        toReturn = prev
        while len(pQueue) > 0:
            temp = heapq.heappop(pQueue)
            prev.next = temp
            prev = temp

        return toReturn.next

#----------------------------------------------------------x-----------------------------------------------------------#

    # Time Complexity : O(n*log(n)), where n is the combined length of all the lists
    # Space Complexity : O(n), heap space.
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a min heap to preserve order,
    # pushes all values into the heap. the values are then
    # popped and the list is remade from those values.
    def mergeKListsExtraListNodes(self, lists):
        # if empty
        if not lists:
            return None
        # if only one sorted list exists
        if len(lists) == 1:
            return lists[0]

        pQueue = []
        for i in lists:
            temp = i
            while temp != None:
                heapq.heappush(pQueue, temp.val)
                temp = temp.next

        prev = ListNode(-1)
        toReturn = prev
        while len(pQueue) > 0:
            temp = ListNode(heapq.heappop(pQueue))
            prev.next = temp
            prev = temp

        return toReturn.next
