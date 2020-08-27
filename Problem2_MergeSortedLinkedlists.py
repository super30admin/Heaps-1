#Problem 2: https://leetcode.com/problems/kth-largest-element-in-an-array/
#Test Cases passed on Leetcode 
#Time Complexity:    O(n.logk)
#Space Complexity:   O(k)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # custom less than comparator using a lambda function taking ListNode objects x and y as parameters
        lessThan = lambda x, y: x.val < y.val
        ListNode.__lt__ = lessThan
        #create a list for heap
        min_heap=[]
        #create a dummy node
        dummyHead=ListNode(-1)
        ptrNode=dummyHead
        for i in range(len(lists)):
            currentHead=lists[i]
            #push the element in heap only when it is not None
            if currentHead!=None:
                heapq.heappush(min_heap,currentHead)
        
        while len(min_heap)>0:
            #pop the min element and append it to the new linkedlist
            min_node=heapq.heappop(min_heap)
            ptrNode.next=min_node
            #push the node only if it exists
            if min_node.next!=None:
                #push the next element from linkedlist from which we got the min element
                heapq.heappush(min_heap,min_node.next)
            #move the ptr to min_node
            ptrNode=min_node
        return dummyHead.next
            