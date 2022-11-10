# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        heap = []
        
        for i, li in enumerate(lists):
            if li:
                heapq.heappush(heap, (li.val,i, li)) # O(log k)
            
        curr = dummy = ListNode(0)
        
        while heap:
            minimum = heapq.heappop(heap)
            minimum = minimum[2]
            curr.next = minimum
            curr = curr.next
            minimum = minimum.next
            
            if minimum != None:
                i += 1
                heapq.heappush(heap, (minimum.val, i, minimum))
                #minimum = minimum.next
            
        return dummy.next
    
    # Time complexity: O(n log K) where n is the number of lists and k is the size of heap. 
    # Space Complexity: O(K)
            
        