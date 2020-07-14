// Time Complexity : O(n*log(n-k)). n is the total number of elements. (n-k) is the number of elements in heap
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> b - a);
        int n=nums.length;
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            pq.add(nums[i]);
            if(pq.size()>n-k){
                min=Math.min(min,pq.poll());
            }
        }
        return min;
    }
}
