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

/*
 * Approach 2 - Using Max Heap. 
 * We maintain a max heap of (n-k) elements so the 4 largest elements will be coming out.
 * in every poll, we store the result in a variable that will store the min of the current and the incoming value.
 * For this to work, we need to initialize a variable to the maximum value of Integer class.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int large = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size() > (n-k))
            {
                large = Math.min(large,pq.poll());
            }
        }
        return large;
    }
}