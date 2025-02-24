// tc: nlog(n-k)
// sc:n-k
class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
         int result = Integer.MAX_VALUE;
         for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>nums.length-k){
                result = Math.min(result,pq.poll());
            }
         }
         return result;
    }
}