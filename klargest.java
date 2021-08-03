//time : O(nlogk)
//Space : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || nums == null)
            return 0;
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        
        for(int num:nums)
        {
            pqueue.add(num);
            
            if(pqueue.size()> k)
                pqueue.poll();
        }
        return pqueue.peek();
    }
}