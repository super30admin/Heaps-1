class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        stack = []
        
        for num in nums:
            stack.append(num)
            stack.sort(reverse=True) #nlogn for sorting
            if len(stack) > k:
                stack.pop()
        
        return stack.pop()
        
#time complexity is O(n(nlogn)) for sorting the array for each element in the input 
#space complexity is O(k)
