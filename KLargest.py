#Time Complexity: O(n)
#Space Complexity: O(k+1)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        large_elements=[]
        for i in nums:
        #implemented using min heap. on pop, minimum element at that point is return so the maximum elements stays in the list
            heapq.heappush(large_elements,i)
            if len(large_elements)>k:
                heapq.heappop(large_elements)
        return large_elements[0]