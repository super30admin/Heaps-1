// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * Maintaina a minHeap to store the elements in the queue.
 * We add every element in the queue, and if the size of the queue is greater than k then remove the top element(mminimum)
 * At end we are left with k large elements in the queue and the top element is the kth largest element in array 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); // O(logk)
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

// Time Complexity : O((n-k)logk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Maintaina a maxHeap to store the elements in the queue.
 * We add every element in the queue, and if the size of the queue is greater
 * than (n-k) then remove the top elementand compare with the result. select the
 * min out of them .
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]); // O(logk)
            if (pq.size() > (n - k)) {
                result = Math.min(result, pq.poll());
            }
        }

        return result;
    }
}