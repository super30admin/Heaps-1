// Time Complexity : O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //base case
        if (nums == null || nums.length == 0)
            return -1;
        
        //Create MinHeap using priority queue - natural ordering - ascending
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        //add first k elements
        for(int i=0;i<k;i++)
            minHeap.add(nums[i]);
        
        //iterate on the rest for adding it to min heap
        for(int i=k;i<nums.length;i++)
        {//add the element if it greater then min element in heap and remove that min element
            if(nums[i] > minHeap.peek())
            {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
