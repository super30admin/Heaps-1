// Time Complexity : O(n log k) where n is the size of the array and k is the k-th number to be found
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using min heap to store the k elements. After adding all numbers, the first number on the heap will be k-th largest number in min heap.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k)
                q.poll();
        }

        return q.peek();

    }
}