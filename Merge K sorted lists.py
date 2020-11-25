# Time:- O(nlogl) l=no. of linkedlists
# Space:- O(n) n=no. of nodes in all the linkedlists
# Approach:- Keep a track of the val and index of the node in the actual list. Pop the (val,index) in the heap. Pop the smallest from 
# the heap Create a ListNode from the val. Go to the index in the original list and increment the next pointer there and store the new val,index in the heap. Keep going till we have no more elements in the heap.
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        my_heap=[]
        if len(lists)==0:
            return
        res=[]
        for i,v in enumerate(lists):
            if v:
                my_heap.append([v.val,i])
        heapq.heapify(my_heap)
        if not my_heap:
            return
        val,idx=heapq.heappop(my_heap)
        node=ListNode(val)
        if lists[idx].next:
            heapq.heappush(my_heap,[lists[idx].next.val,idx])
            lists[idx]=lists[idx].next
        head=node
        while(my_heap):
            val,idx=heapq.heappop(my_heap)
            node.next=ListNode(val)
            if lists[idx].next:
                heapq.heappush(my_heap,[lists[idx].next.val,idx])
                lists[idx]=lists[idx].next
            node=node.next
        return head
        
                            
            
        