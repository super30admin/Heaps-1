// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I have created a minimum heap - minHeap and add elements of the array to it until size of minHeap is less than k. If it becomes equal,
 * I check if the minimum element in heap is less than nums[i]. If so, I add nums[i] to the heap and remove the minimum element. At the
 * end, I return minHeap.peek() which gives the kth largest element.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(minHeap.size()<k)
            {
                minHeap.add(nums[i]);
            }
            else
            {
                if(minHeap.peek()<nums[i])
                {
                    minHeap.add(nums[i]);
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();

    }
}