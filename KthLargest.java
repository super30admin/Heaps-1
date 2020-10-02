/* 215. Kth Largest Element in an Array (MEDIUM)
https://leetcode.com/problems/kth-largest-element-in-an-array/
Did this run successfully on Leetcode : Yes

Approach: Use a min heap to hold the k largest elements of the array
As we add the (k+1)th element, remove the smallest element from the heap.
At the end, the first element in the heap is the kth smallest element in the array.

TC: O(n * log k) => n elements are added + O((n-k)*logk) are polled
SC: O(k) => k elements in Priority Queue
*/

import java.util.PriorityQueue;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            // O(klogk)
            if (i < k) {
                pq.offer(nums[i]);
            } else {
                pq.offer(nums[i]);
                pq.poll();
            }
        }        
        return pq.poll();
    }

    public static void main(String args[]) {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        for (int i = 1; i <= nums.length; i++) {
            System.out.println(findKthLargest(nums, i));
        }        
    }
}
