// Time Complexity : O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.PriorityQueue;

public class LargestelementArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int l = nums.length - k;
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > l) {
                int temp = pq.poll();
                result = Math.min(temp, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2, 2, 7, 5, 6 };
        int k = 2;
        LargestelementArray solution = new LargestelementArray();
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
