'''
Brute force: Sort, reverse, return kth index

'''

'''
We could create a max heap of size K and for each of the remaining 
n elements, we update the heap adquetatly. That would be O(nlog(k))
In python we can do this in one line with heapq.nlargest(k,nums)[-1]. Then we
take the last element of this.But that's cheating. Let's see if we can do it
without heap.
'''

'''
Similarly to quick select, by transforming an array around a pivot,
we know that the pivot is at the right position in a sorted array.
That means that if we get the array such that pivot==k, we have
what we want.
'''
#Problem 1: Kth Largest Element in an Array
#Time Complexity: worse case O(n^2), average(O(n*log(k)))
#Space compelexity: worse case O(n)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        def helper(start,end):
            if start==end:
                return nums[start]
            pivot=nums[start]
            pivot_idx=start
            #move pivot to the end so we know where it is.
            nums[pivot_idx],nums[end]=nums[end],nums[pivot_idx]
            
            #find the good position of pivot
            for i in range(start,end):
                if nums[i]>pivot:
                    nums[i],nums[pivot_idx]=nums[pivot_idx],nums[i]
                    pivot_idx+=1
            #put pivot to the right place
            nums[pivot_idx],nums[end]=nums[end],nums[pivot_idx]
            
            #call condition
            if pivot_idx==(k-1):
                return nums[pivot_idx]
            if pivot_idx>k-1:
                return helper(start,pivot_idx-1)
            else:
                return helper(pivot_idx+1,end)
        return helper(0,len(nums)-1)
