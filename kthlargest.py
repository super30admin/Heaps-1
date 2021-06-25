class Solution:
    
    """
    Description: Find Kth largest element in an unsorted array
    
    Time Complexicity: O(n log K)
    Space Complexicity: O(K)
    where, n -> lenght of the array
    
    Approach: Using Heap
    - in a for loop sucessively heap-push the value
    - keep heappop once the array length becomes larger than k
    - keep first one as the final Kth largest element
    """
    
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        from heapq import heappush, heappop
        
        result = []
        for num in nums:
            heappush(result, num)
            if len(result) > k:
                heappop(result)
                
        return result[0]
