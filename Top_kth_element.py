#Time Complexity: O(nlogk)
#Space Complexity: O(K)
import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        min_heap = []
        for each_ele in nums[:k]:
            heapq.heappush(min_heap,each_ele)
        
        for ele in nums[k:]:
            if ele > min_heap[0]:
                heapq.heapreplace(min_heap,ele)
        return min_heap[0]
            
