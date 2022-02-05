# Heaps-1

## Problem1 
Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

# Time COmplexity =O(nlogk)
# Space COmplexity=O(k)
class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        return heapq.nlargest(k, nums)[-1]
## Problem2

Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

# Time COmplexity =O(nlogk)
# Space COmplexity=O(n)

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        minHeap = []
        
        for i in lists:
            temp_node = i
            while temp_node is not None:
                heappush(minHeap,temp_node.val)
                temp_node = temp_node.next
        
        if len(minHeap) == 0:
            return
        
        resultNode =  ListNode(heappop(minHeap))
        head = resultNode 
        
        
        while len(minHeap) > 0:            
            resultNode.next = ListNode(heappop(minHeap))
            resultNode = resultNode.next

        return head