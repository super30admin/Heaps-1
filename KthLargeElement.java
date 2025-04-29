// Time Complexity :  O(N + K log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

// Approach : 
// Build a max heap with all elements.
// Remove (poll) the largest element K-1 times.
// The next polled element is the K-th largest.

import java.util.*;

public class KthLargeElement 
{
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer a , Integer b) ->
        {
            if((int) a>(int) b)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        });  
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        int i =1;
        while(i!=k)
        {
            maxHeap.poll();
            i++;
        }
        int out = maxHeap.poll();
        return out;
    }
}
