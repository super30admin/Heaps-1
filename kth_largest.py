# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach
#Used quick select and checked if the k is less or greater and approached accordingly

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        #New K
        k=len(nums)-k
        
        def quickSelect(l,r):
            pivot=nums[r]
            pointer=l
            
            for i in range(l,r):
                if pivot>=nums[i]:
                    nums[pointer],nums[i]=nums[i],nums[pointer]
                    pointer+=1
            
            nums[pointer],nums[r]=nums[r],nums[pointer]
            
            if pointer>k: return quickSelect(l,pointer-1)
            elif pointer<k: return quickSelect(pointer+1,r)
            else : return nums[pointer]
            
        return quickSelect(0,len(nums)-1)
    
    
    
   