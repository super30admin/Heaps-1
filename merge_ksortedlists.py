import heapq
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Time complexity: O(n*klogk)
    Space complexity: O(k) --> k elements from k lists in a heap
    """
    
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        # overwriting the comparator function of heap
        ListNode.__lt__ = (lambda j, k : j.val < k.val)
        
        dummy = ListNode(-1)
        curr = dummy
        minHeap = []
        
        # push all the head nodes of the lists into the heap
        for list in lists:
            # checck if the list is empty or not
            if list:
                heapq.heappush(minHeap, list)
        
        # check if the minheap is empty or not
        while minHeap:
            # top elem will be the minimum element of the heap
            top = heapq.heappop(minHeap)
            
            # check if the top elem is pointing to other element 
            # then push that elem into the heap
            if top.next:
                heapq.heappush(minHeap, top.next)
            
            # point the curr.next ptr to the top elem
            curr.next = top
            # move the ptr/ to the next elem
            curr = curr.next
            
        # return the head node of the list
        return dummy.next