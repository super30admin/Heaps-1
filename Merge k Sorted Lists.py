# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    #Solution 1
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #Approach: Priority Queue / Min Heap
        #Time Complexity: O(nk log k)
        #Space Complexity: O(k)
        #where, k is the num of linked lists, and n is the average length of a linked list
        
        ListNode.__lt__ = (lambda a, b : a.val < b.val)
        
        head = pointer = ListNode(-1)
        
        heap = []
        for ls in lists:
            if ls:
                heappush(heap, ls)
                
        while heap:
            pointer.next = heappop(heap)
            pointer = pointer.next
            
            if pointer.next:
                heappush(heap, pointer.next)
                
        return head.next

    #Solution 2
    """
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #Approach: Merge lists in pairs
        #Time Complexity: O(n * k^2)
        #Space Complexity: O(1)
        #where, k is the num of linked lists, and n is the average length of a linked list
        
        merged = None
        
        for ls in lists:
            merged = self.merge(merged, ls)
            
        return merged
    
    def merge(self, l1, l2):
        head = pointer = ListNode(-1)
        
        while l1 and l2:
            if l1.val <= l2.val:
                pointer.next = l1
                l1 = l1.next
            else:
                pointer.next = l2
                l2 = l2.next
            pointer = pointer.next
            
        if l1:
            pointer.next = l1
        if l2:
            pointer.next = l2
        
        return head.next
    """