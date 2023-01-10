# // Time Complexity :O(nlogk) where n is total elements and kis size of heap.
# // Space Complexity : O(k)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Solution:

    ## we have k lists and we need to merge them in a single list in a sorted manner. we create a heap of size k and and add all the heads of the these nodes in a heap . since they are objects. in python we need to overload "<" operator to allow comparing listnodes.
    ## Once we have added our elements in the heap. we pop out the min element and add it to the result. and from whicheven node we got our minimum. we move to node.next of that and push the node and its val into the heap.
    ## return the result list. 
    def mergeKLists(self, lists):
        priorityQueue = []
        ## change in the constructor too accept node values.
        ListNode.__lt__ = lambda a,b: a.val < b.val

        for li in lists:
            if li:
                heapq.heappush(priorityQueue, (li.val, li))

        result = ListNode(0)
        dummy = result
        while priorityQueue:
            val, node = heapq.heappop(priorityQueue)
            
            result.next = node
            result = result.next
            if node.next:
                nextEl = node.next
                nextElVal = node.next.val
                heapq.heappush(priorityQueue, (nextElVal, nextEl))
        
        return dummy.next

