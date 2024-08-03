// Time Complexity : O(NLogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class KthLargestElementInAnArray {
    // Using max heap
    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > nums.length - k){
                result = Math.min(result,pq.poll());
            }
        }
        return result;
    }
}