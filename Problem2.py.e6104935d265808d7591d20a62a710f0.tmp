# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Consider k LinkedLists and n is the avg length of a list
#Time complexity: O(nklog(k))
#Space complexity: O(k)

#Accepted on Leetcode

#Approach
#Construct a min heap of size k with heads of all lists
#Now keep popping from the list -> After each pop, push next element of the poppedNode if exists to the minHeap
#Append poppedNode to a newList -> Repeat above steps until heap exhausts, return newList


class Node:
    def __init__(self, ListNode):
        self.listNode = ListNode
    
    def __repr__(self):
        return self.ListNode
    
    def __lt__(self, other):
        return self.listNode.val < other.listNode.val

import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        #construct a min heap from heads of each list -> define custom wrapper to enable heapq to construct a heap
        heap = []
        heapq.heapify(heap)
        for nodeHead in lists:
            if nodeHead != None:
                heapq.heappush(heap, Node(nodeHead))
        
        #keep a dummy -> keep popping and appending to dummy to get result
        dummy = ListNode(-1)
        curNode = dummy
        while len(heap):
            poppedNode = heapq.heappop(heap)
            if poppedNode.listNode.next != None:
                heapq.heappush(heap, Node(poppedNode.listNode.next))
            curNode.next = poppedNode.listNode
            curNode = curNode.next
        
        return dummy.next

            

