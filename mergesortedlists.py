# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    """
    Description: merge k sorted linked lists
    
    Time Complexity: O(n log k), n is total number of elements (all linked list together)
    Space Complexity: O(k), k is number of linked lists
    
    Approach: Use heapify to sort least value
    1. add all the first heads to a heap
    2. find minimum value by heappop, add to resulted list, and point to the next value in the list with min value
    3. repeat #2 until all the elements are popped and added to the result
    """
    
    from heapq import heappush, heappop
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        if lists == None: return
        
        ListNode.__lt__ = lambda a, b: a.val < b.val
        pq = []
        for head in lists:
            if head: heappush(pq, head)
                
        result = ListNode(-1) # use a dummy node 
        current = result # pointer to final linked list
        while len(pq) > 0 :
            temp = heappop(pq)
            current.next = temp
            if temp.next:
                heappush(pq, temp.next)
            current = temp
            
        return result.next
    
    
