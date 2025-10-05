import heapq
class Solution(object):
    # tc : O(nlogk) insertion, deletetion takes O(logk), for n times in the for loop:  O(n*2logk)-> O(nlogk)
    # sc : O(k)
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # will use min heap 
        # once the size of the heap is greater than k, then we keep poping up the elements as min elemenst stay in the heap and once the size is greater we keep pooping up the min elements eliminating the n-k elements which were the smallest elements then the min element in the heap is the kth largest element in the given list as all the elements less than k were poped up 
        
        pq = [] 
        for i in range(len(nums)):
            heapq.heappush(pq,nums[i]) # heappush adds the element in the heap, heappq maintians the min heap manner ( smallest element as the parent)
            
            if len(pq) > k:  # once added the element and its heapified, we eliminate the min element
                heapq.heappop(pq) # O(logK)
            
        
        # now the heap conists of len n-k where the min element is the kth largest element in the list
        return pq[0]
            