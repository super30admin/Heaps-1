## Problem1 
# Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

# Method1: Using Min Heap
# Time Complexity : O(N * LogK) -- going through all the elements and pushing/ popping from heap. Worst case = O(N * LogN) when k = N
# Space Complexity : O(K) -- size of the heap. Worst case = O(N) when k = N
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Want the kth largest element on the top of the heap
# So keep min heap of k length. Iterate over the array. The min out of the k elements would be at the top of the heap.
# So whenever we find an element greater than the first element of the heap and size of heap = k, we pop the min element and add the new element. 
# So at the end of the array we would have the max k elements of the array in the heap and minimum of them at the top of the heap. 
# So we would get the kth largest element from the top

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # by default it is min heap in python
        minHeap = []
        for i in range(len(nums)):
            if(len(minHeap) < k):
                # keep adding to the heap till we have k elements in the heap
                heapq.heappush(minHeap, nums[i])
            else:
                if(minHeap[0] < nums[i]):
                    # curr element > least of the heap
                    # so curr should be among the max k elements
                    # so replace the top of the heap with the current
                   heapq.heappop(minHeap)
                   heapq.heappush(minHeap, nums[i])

        return minHeap[0]

        
sol = Solution()
print("Using Min Heap")
print(sol.findKthLargest([3,2,3,1,2,4,5,5,6], 4))
print(sol.findKthLargest([3,2,1,5,6,4], 2))


# Method2: Using Max Heap
# Time Complexity : O(N * Log (N - K + 1)) -- going through all the elements and pushing/ popping from heap. Worst case = O(N * LogN) when k = 1
# Space Complexity : O(N- K + 1) -- size of the heap. Worst case = O(N) when k = 1
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only

# Kth largest element is (n - k + 1) elements from the front in sorted order. means largest out of (n - k + 1) elements.
# So we maintain a max heap of (n - k + 1) elements. When size of the heap has become (n - k + 1), 
# and we find if curr element < top heap element then we pop the max element out from the heap and add the curr element into the heap. 
# This is because we need to keep track of (n - k + 1) smallest elements among which the top element would give us the kth largest
# By default we have min heap in python. So we negate all numbers to make it work a max heap

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # 
        maxHeap = []
        for i in range(len(nums)):
            if(len(maxHeap) < (len(nums) - k + 1)):
                # keep adding to the heap till we have n - k + 1 elements in the heap
                heapq.heappush(maxHeap, -nums[i])
            else:
                if(-maxHeap[0] > nums[i]):
                    # curr element < max of the heap
                    # so curr should be among the min k elements
                    # so replace the top of the heap with the current
                   heapq.heappop(maxHeap)
                   heapq.heappush(maxHeap, -nums[i])

        return -maxHeap[0]

sol = Solution()
print("Using Max Heap")
print(sol.findKthLargest([3,2,3,1,2,4,5,5,6], 4))
print(sol.findKthLargest([3,2,1,5,6,4], 2))

# Method3: Using Bucket Sort
# Time Complexity : O(N) + O(max - min)-- O(N) -- going through all the elements to find max and min. 
# Then going through bucket of length (max - min)
# Space Complexity : O(max - min) = O(N) -- creating a bucket of length (max - min)
# Did this code successfully run on GFG : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# - Find min and max of the array
# - Create an array to keep count of frequencies of elements present between min and max
# - So our first index would correspond to value = 0 + min_val
# - So our second index would correspond to value = 1 + min_val
# - After having count of frequencies, we can iterate this array from back that is max value as we need the kth largest
# and keep track of number of elements have passed by decrementing their frequency counts. Once count crosses k, 
# it means that element is our kth largest where our count crossed k. We can get the value of that index by index + min_val

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        def get_min_max(arr):
            minn = arr[0]
            maxx = arr[0]
            i = 0
            
            # for each pair of 2 elements
            # number of comparisons = 3
            # so total comparisons reduced = 3 * (n // 2) + 2 in worst case
            for i in range(1, len(arr), 2):
                if(arr[i] > arr[i - 1]):
                    # check for arr[i] being max
                    # check for arr[i - 1] being min
                    maxx = max(maxx, arr[i])
                    minn = min(minn, arr[i - 1])
                else:
                    # check for arr[i] being min
                    # check for arr[i - 1] being max
                    maxx = max(maxx, arr[i - 1])
                    minn = min(minn, arr[i])
                    
            # if len(arr) was odd we would have to compare the last element
            # Note: i = last index if len(arr) = even. i = last index - 1 if len(arr) = odd
            i += 1
            if(i == len(arr) - 1):
                # we have odd no. of elements
                maxx = max(maxx, arr[i])
                minn = min(minn, arr[i])
            
            return [minn, maxx]

        minn, maxx = get_min_max(nums)
        bucket = [0] * (maxx - minn + 1)# both maxx and min are inclusive

        for i in range(len(nums)):
            # mapping the value to correct index and incrementing frequency
            bucket[nums[i] - minn] += 1

        # iterate from back as we want kth largest
        remain = k
        for i in range(len(bucket) - 1, -1, -1):
            # reduce remain with current frequency count
            remain -= bucket[i]
            # as soon as nothing remains, means we found the kth largest index
            if(remain <= 0):
                # get value from the index
                return (i + minn)

        return -1


sol = Solution()
print("Using Bucket Sort")
print(sol.findKthLargest([3,2,3,1,2,4,5,5,6], 4))
print(sol.findKthLargest([3,2,1,5,6,4], 2))