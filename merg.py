# // Time Complexity :O(Nlogk)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we create a min heap with the head pointers of all LLs given. now we pop the min from the heap everytime - which would give us the min element from all other elems -like this we sort the LLs
import heapq
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap=[]
        for head in lists:
            if(head is not None):
                heapq.heappush(heap,(head.val,head))
        print(heap)
        dummy=ListNode(-1)
        curr=dummy
        while(len(heap)>0):
            val,mmin=heapq.heappop(heap)
            curr.next=mmin
            curr=curr.next
            if(mmin.next is not None):
                heapq.heappush(heap,(mmin.next.val, mmin.next))
        return dummy.next
