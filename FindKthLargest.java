// Time Complexity : O(NlogK) where n is number of elements and k is the input
// Space Complexity : O(k) for using priority queue of size k.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            pq.add(nums[i]);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}
