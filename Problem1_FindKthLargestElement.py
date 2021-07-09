'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 215. Kth Largest Element in an Array


# https://leetcode.com/problems/kth-largest-element-in-an-array/solution/


#-----------------
# Time Complexity: 
#-----------------
# O(L) - Where L is the length of the key

#------------------
# Space Complexity: 
#------------------
# O(1): Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        return heapq.nlargest(k, nums)[-1]
        