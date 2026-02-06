/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Approach - we can use MinHeap to find the Kth largest elements, min heap has the smallest
key has priority
As we add elements, we remove the smallest if the heap grows beyond size k.
In the end, the top of the heap gives us the k-th largest number.
Time Complexity - O(nlogK)
Space Complexity - O(k)
 */

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll(); // remove the min element from the queue
            }
        }
        return pq.peek();
    }
    /*
    Approach - we can use MaxHeap to find the Kth largest elements, Max heap has the largest
    key priority
    We use a max-heap to store all elements in decreasing order.
    As we go beyond (n - k) elements, we keep removing and updating the minimum seen so far.
    Store the kth largest element in the result
    Time Complexity - O(nlog(n-k))
    Space Complexity - O(n-k)
   */

    public int findKthLargestUsingMaxHeap(int[] nums, int k) {
        int n  = nums.length;
        int result  = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);// to
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > n-k) {
                result = Math.min(result,pq.poll()); // calculate the min element of the last n-k elements
            }
        }
        return result;
    }
}
