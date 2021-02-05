//time complexity:nlogk
//space complexity:O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>q= new PriorityQueue<>();
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        while(i<nums.length){
            q.add(nums[i++]);
            if(i>k){
                q.remove();
            }
        }
        return q.remove();
    }
}