# Time complexity : O(n log(k))
# Space complexity : O(k)
# Leetcode : Solved and submitted

from heapq import heappush as push
from heapq import heappop as pop

class Solution:
    # defination of class ListNode
    class ListNode:
        def __init__(self, val):
            self.val = val
            self.next = next
    
    # Defining the Distance class to use the heapq as max_heap
    class Distance:
        def __init__(self, listnode):
            self.listnode = listnode
        # comparing the self and other objects listnode val
        def __lt__(self, other):
            return self.listnode.val < other.listnode.val
    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # declare the default values for minHeap as empty list, and a dumy node
        minHeap = []
        dummy = ListNode(-1)
        
        # put curr as the dummy node created
        curr = dummy
        
        # going over the k lists and appending the object of head to the minHeap
        for i in range(len(lists)):
            currHead = lists[i]
            if currHead != None:
                push(minHeap, self.Distance(currHead))

        # traversing until the minHeap is not empty
        while minHeap:
            # fetch the first node of the heap which is the min
            minNode = pop(minHeap).listnode
            # put curr as the minNode
            curr.next = minNode
            # move curr by one
            curr = curr.next
            # checking if next of minNode is not empty, then we simply push the next of minNode into the Heap and keep om extracting the min from all lists
            if (minNode.next != None):
                push(minHeap, self.Distance(minNode.next))
                
        return dummy.next
