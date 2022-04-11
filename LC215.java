//Time Complexity : O(nlogk)
//Space Complexity : O(n)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int ele = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            
            if(pq.size() > k)
            {
                ele = pq.poll();
            }
        }
        
        return pq.poll();
    }
}