// Time Complexity: O(N log(K))
// Space Complexity: O(K)
// Passed Leetcode
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (minHeap.size() < k) {
                minHeap.add(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
            
        }
        
        
        return minHeap.remove();
    }
}