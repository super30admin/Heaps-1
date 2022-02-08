# Time Complexity nklog(k) where k is the number of lists and n is the average length of lists
# logk is the timecomplexity for heapifying
# Space Complexity o(n)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        heap = []
        
# Initialize heap with first value in each list
# Keep track of which list each value came from 
        
        heapify(heap)
        for a in range(len(lists)):
            if lists[a]!= None:
                heapq.heappush(heap,(lists[a].val,a))
        
        root = ListNode(-1)
        
        curr = root
        
        while heap:
             # Top of the heap is the next element in our result 
            # Idx notes which list the value came from 
            (nextEle , i) = heapq.heappop(heap)
            # O(1) lookup to move the list we just pulled from forward 
            curr.next = ListNode(nextEle)
            curr = curr.next
            
            lists[i] = lists[i].next
            # After moving list forward, add front element to heap if possible 
            if lists[i] != None:
                heapq.heappush(heap , (lists[i].val,i))
                
        return root.next
            
            
            
            
        
        
        
        
        
        
        
         