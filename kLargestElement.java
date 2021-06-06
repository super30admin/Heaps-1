//Time complexity O((nlog(n-k))
//Space complexity O(log(n-k))
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        int maxSize = 0;
        
        for(int i = 0; i < nums.length; i ++){
            
            if(pq.size() < nums.length - k){
                
                pq.add(nums[i]);
            }
            
            else {
                
                pq.add(nums[i]);
                int temp =   pq.poll();
               result = Math.min(result,temp);
                
            }
        }
      //  System.out.print(pq);
        return result;
    }
}