//Time Complexity:O(nlog(n-k))
//Space complexity :O(n-k)
//Google Interview
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //min heap based solution 
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
