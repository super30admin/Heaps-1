# Using Min Heap
# Time Complexity = O(nk log(k)), where k = number of lists, n = avg length of lists, n*k = total number of elements/nodes in the merged list, log(k) = TC for insertion in priority queue for 1 element

# Space Complexity = O(k), k = number of lists, and we are storing head of lists, so max capacity = number of heads in k lists, which is = k (heap/priority queue)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq

class Solution:
    def mergeKLists(self, lists: list[Optional[ListNode]]) -> Optional[ListNode]:
        if lists == None or len(lists) == 0:
            return None
        
        ListNode.__lt__ = lambda x, y : x.val < y.val
        
        minHeap = []
        
        # Creating a dummy node 
        dummy = ListNode(-1)
        curr = dummy
        
        for head in lists:
            if head != None:
                heapq.heappush(minHeap, head)
                
        
        while(minHeap):
            minNode = heapq.heappop(minHeap)
            curr.next = minNode
            if (minNode.next != None):
                heapq.heappush(minHeap, minNode.next)
                
            curr = curr.next
            
        
        return dummy.next
    