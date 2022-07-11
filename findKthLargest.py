#Time complexity : O(nlogk) where n is the size of nums and logk each time adding element in the heap of size k and heapify after adding each element
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/kg2-5xTrfQY
import heapq as hp
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums)==0:
            return -1
        #initialising an empty list which can act as priority queue or heap
        heap = []
        #adding the elements in heap of size k i.e. at the end from the min heap we can get the largest kth number
        for i in nums:
            #we will add the element one after annd heafiy after adding each element and addind element in heap will generate logk time.
            hp.heappush(heap,i)
            #after appending the element we are checking the size of the heap does it excced the length from k if it does that we will pop the minimumum element from the heap
            if len(heap)>k:
                hp.heappop(heap)
        return hp.heappop(heap)
