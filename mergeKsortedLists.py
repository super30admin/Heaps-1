#Time Complexity : O(nklogk) where n is the average length of the lists and k is the number of the lists
#Space Complexity : O(k) where k is the number of the lists
#Did this code successfully run on Leetcode : Yes

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #override the internal function to compare the nodes value
        ListNode.__lt__ = lambda self, other: self.val < other.val

        #make dummy head and result linkedlist head pointing to the same node
        head = newNode = ListNode(-1)

        heap = []

        #go through all lists and add their heads to out heap
        for l in lists:
            if l:
                heapq.heappush(heap, (l))

        while heap:
            #pop min node from heap
            curr = heapq.heappop(heap)
            #add the node to result linkelist
            newNode.next = ListNode(curr.val)
            #move to next node
            newNode = newNode.next
            curr = curr.next
            #add next node to heap
            if curr:
                heapq.heappush(heap, (curr))

        return head.next
