class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        """add all the elements to priority queue and remove, heapify when length of heap exceeds k-----using minheap
        Time complexity-O(nlog(k)) as iterating over n elements and to push and pop elements from heap, it require log(k) operations
        space complexity-O(k)"""
        # h=[]
        # for num in nums:
        #     heapq.heappush(h,num)
        #     if len(h)>k:
        #         heapq.heappop(h)
        # return h[0]
        """if nums length <=2, then use heappush to add them to priority queue,
        else use pushpop func to add the current element and remove the min ele----using minheap"""
        # h=[]
        # for i in range(len(nums)):
        #     if i+1<=k:
        #         heapq.heappush(h,nums[i])
        #     else:
        #         heapq.heappushpop(h, nums[i])
        # return h[0]
        """constructing minheap of k largest elements using nlargest func in python and         returning last value of it-----using minheap
        """
        # li=heapq.nlargest(k, nums)
        # return li[-1]
        """In python, priorityqueue only support minheaps
        One way to implement maxheaps is to take negative of all numbers and while comparing result and popped element then covert it to actual value by multiplying again by -1
        Time complexity-O(nlog(n-k)) as we always heapify n-k elements which are in stack
        space complexity-O(n-k)"""
        h=[]
        result=100000
        for num in nums:
            heapq.heappush(h,-1*num)
            if len(h)>len(nums)-k:
                result=min(-1*heapq.heappop(h), result)
        return result
        
       