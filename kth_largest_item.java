class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)->b-a );//max heap
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        
        for(int num: nums){
            pq.add(num);
            if(pq.size() > n-k){
                result = Math.min(result, pq.poll());
            }
        }
        
        return result;
        
    }
}

//TC: n log(n-k)
