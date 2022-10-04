class Solution {
    //min heap
    //tc- o(nlog(n-k)) where is k is kth largest element
    //sc- o(n-k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int min = Integer.MAX_VALUE;
        for(int num : nums)
        {
            pq.add(num);
            
            if(pq.size()>nums.length-k)
            {
                
                min = Math.min(min,pq.poll());
               
            }
        }
        return min;

    }
}