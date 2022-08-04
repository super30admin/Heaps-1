// TC : O(nlog(n-k))
// SC : O(n-k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        // maxheap solution
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result = Integer.MAX_VALUE;
        
        for(int num:nums){
            pq.add(num);
            if(pq.size()>nums.length-k){
                result = Math.min(result,pq.poll());
            }
        }
            return result;
    }
}



// TC : O(nlog(k))
// SC : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        // minheap solution
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
            return pq.poll();
    }
}