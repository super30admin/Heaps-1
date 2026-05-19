// Time Complexity : O(n log k) because heap size is maintained at k throughout the traversal
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a Min Heap to keep track of the k largest elements seen so far in the array.
// For every number, we add it into the heap and remove the smallest element if the heap size becomes greater than k.
// After processing all elements, the top of the Min Heap represents the kth largest element.

class Solution {

    public int findKthLargest(int[] nums, int k) {

        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // add current element
            pq.add(nums[i]);

            // keep heap size equal to k
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // kth largest element
        return pq.peek();
    }
}