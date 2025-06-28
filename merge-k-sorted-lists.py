# // Time Complexity : O(Nlog(k*n))
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# brute force is to just add all elements to a list and sort it 
# second way would be to have 2 pointers, and merge sort two lists at a time
        

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # we can do better: 
        # 1. add all the curr_nodes of the lists to a min heap
        # 2. pop the top & add to our answer linked list
        # 3. add element from the list from where we popped, and call heapify again

        # declare the heap
        pq = []

        # add heads
        for i, head in enumerate(lists):
            if head:
                heapq.heappush(pq, (head.val, i, head))

        # initiate result linked list
        dummy = ListNode(0)
        curr = dummy

        # continue until there is something in the pq 
        while pq:
            val, i, node = heapq.heappop(pq)
            curr.next = node
            curr = curr.next

            # continue until there is a next for the list that gave current smallest value
            if node.next:
                heapq.heappush(pq, (node.next.val, i, node.next))

        return dummy.next