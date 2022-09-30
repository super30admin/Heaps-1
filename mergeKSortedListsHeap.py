"""
Time Complexity : O(nklogk) where n is the average number of elements in the array and k is the number lists.
                  Heapify will take place for k times so logk and it will be performed on all the elements hence nk
Space Complexity : O(logk ) where k is the number of lists.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Idea is to perform the Heap Sort. 
1. Initially, first elements of all the list will be inserted to heap. At the time of insertion heapify will take place and we will pop the minimum element (the top element will be the smallest as all the lists are already sorted and we are perfroming heapify on minHeap).
2. After that whatever elements is pop, we will go to the next element in that array from which the element was popped and again heapify will take place.
3. This process will take place until all the elements in all the lists are visited and the heap becomes empty
"""
import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        result = ListNode(None)
        curr = result
        for i , head in enumerate(lists):
            if head:
                heapq.heappush(heap, (head.val, i, head))
    
        while(heap):
            minVal, minIdx, minNode = heapq.heappop(heap)
            minNext = minNode.next
            minNode.next = None
            curr.next = minNode
            curr = curr.next
            
            if minNext:
                heapq.heappush(heap, (minNext.val, minIdx, minNext))
        
        return result.next
            


