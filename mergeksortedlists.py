# Time Complexity : O(N log K) where N is the total number of elements in all lists and K is the number of linked lists
# Space Complexity : O(K) where K is the number of linked lists
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Your code here along with comments explaining your approach:
# I am using a min heap to store the smallest element among the k linked lists.
# I am iterating through the list of linked lists and adding the first element of each linked list to the min heap.
# I am also maintaining a counter to avoid comparison between ListNode objects
# I am then creating a dummy node to store the result and a current pointer to traverse the result linked list.
# I am then iterating through the min heap until it is empty.
# I am popping the smallest element from the min heap and adding it to the result linked list.
# I am then checking if the popped element has a next node. If it does, I am adding the next node to the min heap.
# Finally, I am returning the next node of the dummy node as the result linked list.


from typing import List, Optional
import heapq
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        minheap = []
        counter = 0
        for i in lists:
            if i:
                heapq.heappush(minheap,(i.val,counter,i))
                counter+= 1
        dummy = ListNode(0)
        curr = dummy
        while minheap:
            minval,_,minnode = heapq.heappop(minheap)
            curr.next = minnode
            curr = curr.next
            if minnode.next:
                heapq.heappush(minheap,(minnode.next.val,counter,minnode.next))
                counter += 1
        return dummy.next
        