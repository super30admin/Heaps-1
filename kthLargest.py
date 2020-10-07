"""
215. Kth Largest Element in an Array

Time Complexity: O(K∗logK+(N−K)∗logK), which is asymptotically equal to O(N*logK) where n = number of elements
Space Complexity : O(k) 

Approach: Heap
1. Create a min heap and store first k values in it
2. Go through the remaining numbers of the array, if the number from the array is bigger than the top(smallest) number of the min-heap, 
remove the top number from heap and add the number from array
3. Return the top most element in heap

"""

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
      
        minheap = []
        for i in range(k):
            heappush(minheap,nums[i])

        for i in range(k,len(nums)):
            if nums[i] > minheap[0]:
                heappop(minheap)
                heappush(minheap,nums[i])
        return minheap[0]
        