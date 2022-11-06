// Time Complexity:O(nlogk)
// Space Complexity: O(k)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this:No


// Your code here along with comments explaining your approach
/*
 * Remember, for largest - use minHeap and vice versa. By default declaring a PQ will give us a minHeap.
 * We are maintaining a heap of size 4 and inserting element one by one. Once, you insert an element, check the size,
 * if the size is more than the size, delete the minimum element and reorder the heap.
 * In the end, you will be left with 4 elements in which the smallest element will be the fourth largest element.
 */

import java.util.PriorityQueue;

public class Klargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num:nums)
        {
            pq.add(num);
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
