'''
Difference between divide and conquer and dynamic programming is divide and conquer solves problem that 
are independent sub-problems. DP is solving overlaping sub-problems. 

Time Complexity - O(Nklogk) where k is the capacity and n is the average length of the list
Space Complexity : O(k) 

Algorithm - The basic approach would have been using 2 pointers approach or 
merging 2 lists at a time.(Divide and Conquer)
The better approach id to put all the heads inside a heap. Whichever heap 
returns lowest value, put its next insid heap
Simultaneously, keep on removing the minimum value from the heap and keep on appending to the list
'''


from heapq import heappush,heappop
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        
        if lists == None or len(lists)==0:
            return None
        
        ListNode.__lt__ = lambda x, y: x.val < y.val
        
        dummy=ListNode(0)
        cur=dummy
        heap=[]
        
        for node in lists:
            if node != None:
                heapq.heappush(heap,node)
        
        while heap:
            cur.next = heapq.heappop(heap)
            cur=cur.next
            if cur.next!=None:
                heapq.heappush(heap,cur.next)
                
        return dummy.next
        