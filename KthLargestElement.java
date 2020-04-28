// Time Complexity : O(n log(k))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    // Brute Force Time: O(n log(n)) Space:O(1)
    public int findKthLargestBF(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Time: O(nlog(k)) Space: O(n)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++){
            res = pq.poll();
        }

        return res;
    }

    //Time: O(nlog(k)) Space: O(k)

}
