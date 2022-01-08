# Time: O(klogk+(n-k)logk)
# Space: O(k)
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # using max heap
        #add all elements to the heap and remove k-1 elements
        import heapq
        heap_arr = list(nums[0:k])
        #new_ls = list(nums)
        heapq.heapify(heap_arr)
        for i in range(k, len(nums)):
            if nums[i] > heap_arr[0]:
                heapq.heappop(heap_arr)
                heapq.heappush(heap_arr,nums[i])
        return heap_arr[0]
        
