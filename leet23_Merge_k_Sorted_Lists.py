# Solution

# // Time Complexity : O(nklogk), since we are adding all the nodes into minheap and maxsize of minheap will be k. The reason
#                      is that, at a time we add head of all the k linkedlists. Now we take the minimum out before adding the
#                      next node of the taken out node. This happens each time for any minimum node we take. We always take
#                      one node out before adding one more and at the first we would have added k nodes to start with. Since
#                      insert takes logn where n is size of queue, here it will be logk and we have nk nodes. So nklogk
# // Space Complexity : O(k), explanation is same as time complexity explanation
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is, since we know all the individual k linkedlists are already sorted. We can add head node of each linked list to
# priority queue. Once added, if we pop, now we are basically comparing, all the first values of each linkedlist. Since they are
# the smallest in each of their own linkedlist, when we pop we get the minimum of all the linkedlists. Now we can save the next
# node of the popped node into queue again, which take logk time to perform the heapify and keep the min node on the top. This
# can be repeated till all the nodes are added and popped.

# This does not run here since I have not created the nested list with linkedlists

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from queue import PriorityQueue
import math
class Solution:
    def mergeKLists(lists):
        minHeap = PriorityQueue(len(lists))
        
        count = 0
        for head in lists:
            if head != None:
                minHeap.put((head.val,count,head))
                count += 1
        
        result = ListNode(-math.inf)
        cur = result

        while not minHeap.empty():
            tempTuple = minHeap.get() 
            cur.next = tempTuple[2]
            cur = cur.next
            if cur.next != None:
                minHeap.put((cur.next.val,count,cur.next))
                count += 1
        
        return result.next
