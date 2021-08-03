// Time Complexity : O(nlogn) for sorting
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int len = nums.length;
        int klargestindex = len - k;
        return nums[klargestindex];
    }
}