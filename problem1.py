# problem 1 
 

# https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        min_val = float('inf')
        max_val = float('-inf')
        # find the min and max 
        for num in nums:
            min_val = min(min_val,num)
            max_val = max(max_val,num)
        # count the number of each occurance 
        count_arr = [0]*((max_val-min_val)+1)
        for num in nums:
            count_arr[num-min_val]+=1
        counter = k
        for i in range(len(count_arr)-1,-1,-1):
            counter -= count_arr[i]
            if counter <= 0:
                return i+min_val
        return -1