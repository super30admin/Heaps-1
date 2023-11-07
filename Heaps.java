// Time Complexity : O(n*log(n-K))
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

// Your code here along with comments explaining your approach

class Heaps {
    public int findKthLargest(int[] nums, int k) {
        int minNum = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>(nums.length-k)){
                 minNum = Math.min(pq.poll(),minNum);
            }
               
        }
         return minNum;
    }
   
}