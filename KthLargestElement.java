// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class KthLargestElement {
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            // PriorityQueue<Integer> pq = new PriorityQueue<>();
            // for(int num : nums){
            //     pq.add(num);
            //     if(pq.size() > k){
            //         pq.poll();
            //     }
            // }
            // return pq.peek();

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            int result = Integer.MAX_VALUE;
            int n = nums.length;

            for(int num : nums){
                pq.add(num);

                if(pq.size() > (n - k)){
                    result = Math.min(result, pq.poll());
                }
            }
            return result;
        }
    }
}
