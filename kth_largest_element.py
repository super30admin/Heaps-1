""" 
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Time Complexity: O(nlogn) for sorting, O(nlogk) for max heap, O(n) for quick select

"""

#using sorting
def findKthLargest(nums, k):
    nums.sort()
    return nums[-k]

#using max heap
import heapq
def findKthLargest(nums, k):
    heap = []
    for num in nums:
        heapq.heappush(heap, num)

        if len(heap) > k:
            heapq.heappop(heap)
            
    return heapq.heappop(heap)
    
    
    
#using quick select

def findKthLargest(nums, k):
    
    #write code without comments
    def partition(nums, low, high):
        pivot = nums[high]
        i = low-1
        for j in range(low, high):
            if nums[j] > pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        nums[i+1], nums[high] = nums[high], nums[i+1]
        return i+1
    
    def quickSelect(nums, low, high, k):
        if low <= high:
            p = partition(nums, low, high)
            if p == k:
                return nums[p]
            elif p < k:
                return quickSelect(nums, p+1, high, k)
            else:
                return quickSelect(nums, low, p-1, k)
            
    return quickSelect(nums, 0, len(nums)-1, k-1)


    