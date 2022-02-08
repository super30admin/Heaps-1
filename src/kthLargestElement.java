import java.util.PriorityQueue;
/*
// Time Complexity : O(NLogK)
// Space Complexity : O(K)

 */
public class kthLargestElement {
    class Solution {
        public int findKthLargest(int[] nums, int k) {

            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (a-b))  ;
            for(int i =0;i<nums.length;i++) {
                q.add(nums[i]);
                if(q.size()>k) {
                    q.poll();
                }
            }
            return q.poll();
        }
    }
}
