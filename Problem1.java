//Time Complexity : O(nlogk)
//Space Complexity : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length <=0 || nums.length < k){
            return -1;
        }
    PriorityQueue<Integer> q = new PriorityQueue<>();
        
    for(int i : nums){
        q.offer(i);
        
        if(q.size() > k){
            q.poll();
        }
    }
        
        return q.peek();
    }
}