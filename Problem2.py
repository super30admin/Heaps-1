#Time complexity is O(NK) where n is the total number of values in all the given lists
#Space complexity is O(N)
#Program ran successfully on leet code
#No issues faced while coding

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        #Creating a priority queue
        pq=[]
        #Creating a dummy variable of tyoe ListNode
        dummy=ListNode(-1)
        #We are creating a new curr variable and we are assigning to dummy
        curr=dummy
        for head in lists:
            if(head!=None):
                #We are psuhing all the heads references as well as thier values into the heap
                heapq.heappush(pq,(head.val,head))

        #Since we are maintaining the min heap, minimumnodes will come to the top
        while(len(pq)):
            minNode_val,minNode=heapq.heappop(pq)
            #We are pushing the reference of minNode into current.next
            curr.next=minNode
            curr=curr.next
            #We will be pushing the next node of minNode into the heap
            if(minNode.next!=None):
                heapq.heappush(pq,(minNode.next.val,minNode.next))
        #Once all the noces are attached to the current, we will return next reference of the dummy
        return dummy.next
        