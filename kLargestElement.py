class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        #QuickSelect
        #Quick select method
        # It is not quick sort where we sort left and right portion which makes it o(nlogn), but here we sort only one side i.e first we run quick select on n items, then n/2, then n/4.....etc = 2n =>o(n). only in worst case where kth element is located at last then it becomes o(n^2)
        #Time complexity - O(n) averagely partioning and searching.  Worst case is O(n^2) when k=n
        #Space complexity - O(1) - heap size
        def quickSelect(l,r):
            pivot = nums[r]
            p = l

            for i in range(l,r):
                if nums[i]<=pivot:
                    nums[p], nums[i] = nums[i], nums[p]
                    p+=1
            
            nums[p], nums[r] = nums[r], nums[p]
            print(p, " ", nums[p])
            if p==k:
                return nums[p]
            elif p>k:
                return quickSelect(l,p-1)
            else:
                return quickSelect(p+1, r)
        
        #Here we find (n-k)th smallest num in nums
        k = len(nums)-k
        return quickSelect(0, len(nums)-1)

#-----------------------------------------OR--------------------------------------------------


        #Using max heap approach to find the (n-k)th smallest element. Heap of size (n-k) is created. All (n-k) smallest elements are held in queue and the next smallest is poped out which is stored in minval variable.
        #Time complexity - O(nlog(n-k)) inserting n elements into heap of size n-k
        #Space complexity - O(n-k) - heap size
        maxHeap = []
        minval = math.inf
        n = len(nums)

        for i in range(n):
            heapq.heappush(maxHeap, -1*nums[i])
            if len(maxHeap)>(n-k):
                minval = min(minval, -1*heapq.heappop(maxHeap))

        return minval


#-----------------------------------------OR--------------------------------------------------

        #Using min heap approach. Here we create a heap of size k, hence top of heap holds the kth largest element.
        #Time complexity - O(nlogk) inserting n elements into heap of size k
        #Space complexity - O(k) - heap size
        minHeap = []
        
        for i in range(len(nums)):
            heapq.heappush(minHeap, nums[i])
            if len(minHeap)>k:
                heapq.heappop(minHeap)
        return heapq.heappop(minHeap)


#-----------------------------------------OR--------------------------------------------------

        #Sorting approach
        #Time complexity - O(nlogn) for sorting
        #Space complexity - O(1)
        nums.sort()
        return nums[len(nums)-k]
        