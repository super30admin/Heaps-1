# Time Complexity :  O(nk log K) k is number of lists and N is the max length of a list
# Space Complexity : O(K) the heap size
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        """
        Brute force - convert list into an array and sort it. Then change to list. O(nk log nk)
        Can merge lists -> O(Nk^2)
        """
        if not lists:
            return None
        #comparator to compare ListNode values
        ListNode.__lt__ = (lambda a, b : a.val < b.val)
        
        heap = []
        dummy = ListNode()
        res = dummy 
        
        for i in lists:
            if i != None:
                heappush(heap, i)
        
        while heap:
            minNode = heappop(heap)
            dummy.next = minNode 
            dummy = dummy.next 
            #whatevere node is popped, we push in it's next node
            if minNode.next != None:
                heappush(heap, minNode.next)
                
        return res.next