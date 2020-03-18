# Problem 1 - Kth Largest Element in an Array
## Time Complexity :
O(NlogK)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
    from heapq import heappop, heappush, heapify
    class Solution:
        def findKthLargest(self, nums, k):
                minheap = []
                for i in range(k):
                    heappush(minheap, nums[i])
                for i in range(k,len(nums)):
                    if nums[i]>minheap[0]:
                        heappop(minheap)
                        heappush(minheap,nums[i])
                return minheap[0]

# Problem 2 - Merge k Sorted Lists
## Time Complexity :
O(NlogN)

## Space Complexity :
O(N)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
    class Solution:
        def mergeKLists(self, lists: List[ListNode]) -> ListNode:
            self.nodes = []
            head = point = ListNode(0)
            for l in lists:
                while l:
                    self.nodes.append(l.val)
                    l = l.next
            for x in sorted(self.nodes):
                point.next = ListNode(x)
                point = point.next
            return head.next
