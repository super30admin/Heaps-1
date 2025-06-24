import java.util.*;

/*
Time Complexity: O(N log K) where N is n*k and n is the number of elements in the array and K is the size of the heap.
Space Complexity: O(K) for the max heap to store the k largest elements.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: We can use a min-heap (priority queue) to efficiently find the k-th largest element. We add elements to the heap until its size exceeds k, at which point we remove the smallest element. After processing all elements, the root of the heap will be the k-th largest element.
*/

public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
