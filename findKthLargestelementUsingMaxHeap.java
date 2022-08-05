//Time Complexity:O(nlog(n-k))
//Space complexity :O(n-k)
//Google Interview
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result =Integer.MAX_VALUE;
        
        //max heap based solution 
        for(int num : nums){
            pq.add(num);
            if(pq.size()>nums.length-k){
                result = Math.min(result,pq.poll());
            }
        }
        return result;
    }
}