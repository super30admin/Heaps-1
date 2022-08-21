// Time Complexity : O(nlogn)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n =nums.length;
        int result=Integer.MAX_VALUE;
        int temp=0;
        if(nums== null || nums.length==0)
        {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size()>n-k)
            {
                temp= pq.poll();
                result= Math.min(result,temp);
            }
        }
        return result;
    }
} 