#Time complexity : O(nlogk) where n is the total number of nodes and logk each time adding k linkedlist in the heap
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/kg2-5xTrfQY
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq as hp
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #designing comparator opertor by using lambda function
        lessthan = lambda x,y : x.val < y.val
        ListNode.__lt__ = lessthan
        #creating min heap
        heap =[]
        #creating a result linked list 
        result = ListNode()
        head = result
        #push into minheap all the heads of all given linkedList
        for i in range(len(lists)):
            current = lists[i]
            #checking if any given linked list is empty before pushing
            if current != None:
                hp.heappush(heap, current)
        #now appending nodes in the result linkedlist once we get the smallest node by comparing all Linkedlist
        while len(heap)>0:
            #poping the minimum Node from the heap
            minimumNode = hp.heappop(heap)
            #assigning the minimum node to the result and point the head to the new node for creating a link
            head.next = minimumNode
            head = head.next
            #checking the minimum poped node next is not none else we we again add it to the heap
            if minimumNode.next!=None:
                hp.heappush(heap, minimumNode.next)
        return result.next
