import heapq
"""
23. Merge k Sorted Lists
Time Complexity - O(nlog(k))
Space Complexity - O(k)
Make a heap of size(k) and push all (first elements,index of list) of linkedlist to heap and store index and corresponding node in pointer dictionary
Pop min element from heap and from pop element connect start node.next to min element node (get it from dictionary with corresponding index from popped heap value) and push next node of that list to heap and update dictionary with next node address
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        heap = []
        pointer = {}
        
        for index,list_val in enumerate(lists):
            if list_val:
                pointer[index] = list_val
                heapq.heappush(heap,(list_val.val,index))
        
        if len(heap) == 0:
            return None
        
        dummy = ListNode(-1)
        curr = dummy
        
        while(heap):
            temp = heapq.heappop(heap)
            node = pointer[temp[1]]
            if node.next != None:
                pointer[temp[1]] = node.next
                heapq.heappush(heap,(node.next.val,temp[1]))
            
            curr.next = node
            curr = curr.next
        
        return dummy.next
            
        
