// Time Complexity :O(nlog(k))
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Min Priority queue to keep track of largest integer and the size will be k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
                //When the size exceeds k, remove the top integer which is the min
                pq.add(nums[i]);
                if(pq.size() == k+1){
                    pq.poll();
            }
        }

        return pq.peek();
    }
}