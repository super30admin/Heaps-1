package Heaps1;

import java.util.PriorityQueue;

public class question82_kthLargestElementInArray {
    /* Created by palak on 7/6/2021 */

    /**
     Using Priority Queue:
         Time Complexity: O(n)
         Space Complexity: O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
