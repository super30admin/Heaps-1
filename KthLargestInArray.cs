using System;
namespace Algorithms
{
    public class KthLargestInArray
    {
        /// Time Complexity : O(nLogk) 
        // Space Complexity :O(k)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public int findKthLargest(int[] nums, int k)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->a - b);
            for (int i = 0; i < nums.length; i++)
            {
                pq.add(nums[i]);
                if (pq.size() > k)
                {
                    pq.poll();
                }

            }
            return pq.peek();
        }
    }
}
