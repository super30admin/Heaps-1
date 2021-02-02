class Solution:
    #Solution 1
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #Approach: Priority Queue / Min Heap
        #Time Complexity: O(n log k)
        #Space Complexity: O(k)
        #where, n is the length of nums
        
        min_heap = []
        
        for num in nums:
            heappush(min_heap, num)
            if len(min_heap) > k:
                heappop(min_heap)
                
        return min_heap[0]
    
    #Solution 2
    """
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #Approach: Priority Queue / Max Heap
        #Time Complexity: O(n log (n - k))
        #Space Complexity: O(k)
        #where, n is the length of nums
        
        max_heap = []
        
        for num in nums:
            heappush(max_heap, (-num, num))
            if len(max_heap) > len(nums) - k + 1:
                heappop(max_heap)
                
        return max_heap[0][1]   #storing tuples in the heap
    """
    
    #Solution 3
    """
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #Approach: Priority Queue / Max Heap
        #Time Complexity: O(n log (n - k))
        #Space Complexity: O(k)
        #where, n is the length of nums
        
        max_heap = []
        
        curr_min = float('inf')
        for num in nums:
            heappush(max_heap, (-num, num))
            if len(max_heap) > len(nums) - k:
                curr_min = min(curr_min, heappop(max_heap)[1])   #pops kth largest or greater
                
        return curr_min   #storing tuples in the heap
    """