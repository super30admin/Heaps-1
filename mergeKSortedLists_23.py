# // Time Complexity : O(N logK)
# // Space Complexity : O(K)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Approach 1: Two pointers
# Keep two pointers on first two lists, compare and merge them and then keep merging that merged list with next list after comparing, Time complexity: O(k *(m+n)) upper bounded to O(n^2), where k is the number of sorted lists and n+m is the size of two lists getting merged

# Approach 2: Minheap
# Take all elements of an array and put it in minheap, do this for k lists and return the final list
# Time complexity: O(N logN), where N is total number of elements in k lists, Space: O(N)

# Approach 3: Minheap (storing list heads)
# Add head nodes of K lists in the minHeap
# To create the list:While minheap is not empty:-> pop the first list node, and add to output. Move pointer to next list node and add that list node to heap.
# Now, pop again and add to output, increase the pointer to its next and insert that to minheap.
# do the same K times one after the other

# Time complexity: O(N logK), Space: O(K)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        #build a comparator
        lessThan = lambda s1, s2: s1.val < s2.val
        ListNode.__lt__ = lessThan
        
        minHeap = []
        
        for l in lists:
            #push the element in heap when it is not none
            if l != None:
                heapq.heappush(minHeap, l)
        
        #dummy node so that we don't lose our head pointer
        dummyHead = ListNode(-1)
        head = dummyHead
        
        while minHeap:
            #pop min element and add to output
            top = heapq.heappop(minHeap)
            
        
            if top.next != None:
                heapq.heappush(minHeap,top.next)
            
            head.next = top
            head = head.next
            
        return dummyHead.next
        
        
        
        
        