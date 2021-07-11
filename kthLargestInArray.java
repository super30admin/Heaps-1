// Time Complexity : O(N) where N =  length of nums array
// Space Complexity : O(K+1) where K = number  given to us  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. Add element in the minQueue
	2. Once there are more numbers than K remove the smallest element
	3. After the traversal is done the min element left is the answer
*/


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
