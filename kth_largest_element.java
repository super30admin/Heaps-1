//TC: O(nlog(k))
//SC: O(1) 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            q.add(nums[i]);
            if(q.size()>k)
            {
                q.poll();
            }
        }
        return q.peek();
    }
}