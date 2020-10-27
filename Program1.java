// Time Complexity: O(N log(N))
// Space Complexity: O(N)
// Passed Leetcode
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            minHeap.add(-nums[i]);
            
        }
        
        for (int i = 0; i < k - 1; i++) {
            minHeap.remove();
        }
        return -minHeap.remove();
    }
}