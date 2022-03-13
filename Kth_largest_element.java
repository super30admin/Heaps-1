//minheap
//Time Complexity: n logk
//space: k

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        q.add(nums[0]);
        
        for(int i =1;i<nums.length ;i++)
        {
            q.add(nums[i]);
            if(q.size() >k)
            {
                q.poll();
            }
        }
        
        return q.poll();
        
    }
}