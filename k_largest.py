# Time complexity - O(nlog(k)) where n :total number of nodes in entire lists and  k : length of list array
# Space Complexity: O(k)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #MinHeap
        heap = []
        
        for num in nums:
            #Add num to the Heap
            heappush(heap,num)
            #If the size of the heap > k
            if len(heap) > k:
                #Remove from Min Heap
                heappop(heap)
                
        #return top of the heap
        return heap[0]
        