class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        '''
        Time Complexity: O(nlogk)
        Space Complexity: O(k)
        
        '''
        import heapq
        hp =[]
        for i in range(0,len(nums)):
            heapq.heappush(hp,nums[i])
            if(len(hp)>k):
                heapq.heappop(hp)
        
        return heapq.heappop(hp)
