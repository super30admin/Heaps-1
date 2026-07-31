// Time Complexity : O(n log n) where n is the number of elements in the array
// Space Complexity : O(1) if we ignore the space used by the sorting algorithm
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach : sort the array in ascending order and return the element at index length - k, which will be the kth largest element in the array.
class Solution {
   public int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
       return nums[nums.length - k];
   }

}

