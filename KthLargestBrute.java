import java.util.Arrays;

// TC - O(N logN)
// SC - O(N)

public class KthLargestBrute {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
