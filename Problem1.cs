// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I create a minheap and add the elements to the heap until it's size = k. If the size of the heap becomes equal to k, I check if the minimum element in the heap is less than current element being
tracked, if so I remove the minimum element from the heap and add the current element to the heap. At the end, I return the minimum element that exists in the heap.
*/

public class Solution {
    public int FindKthLargest(int[] nums, int k) {
        PriorityQueue<int, int> minHeap = new();

        for(int i = 0; i < nums.Length; i++)
        {
            if(minHeap.Count == k)
            {
                if(minHeap.Peek() < nums[i])
                {
                    minHeap.Dequeue();
                    minHeap.Enqueue(nums[i], nums[i]);
                }
            }

            else
            {
                minHeap.Enqueue(nums[i], nums[i]);
            }
        }

        return minHeap.Peek();
    }
}