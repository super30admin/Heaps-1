// Time Complexity: O(n log (n - k)
// Space Complexity: O(k)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

//When you want to find largest then use minHeap, when you want to find Smallest use maxHeap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        //Max Heap Solution
        for(int num: nums){
            pq.add(num);
            if(pq.size() > nums.length - k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}