// Time Complexity : n* log(k) or n* log(n-k)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes.. had to learn 

/*
 * Using min heap:
 * BY default PriorityQueue is min heap. 
 * Keep adding elements to min heap, when size of q execeeds k remove the top element(which is the mininum), 
 * as we do this we remove all the min elements and the last min element in the priority queue of size k is the kth largest number.
 * 
 * Using Max heap:
 * Convert the PriorityQueue to take max heap . for a,b if b is greater bring it to front.
 * result is some maxvalue
 * store n-k max elements in queue; if queue overflows n-k then pop the element and assign result to wich ever is min.
 * 
 * return result
 */

import java.util.*;

public class KthLargestElement {

    // Using max heap
    // Question: how to write Max Heap? why take n-k?
    public int findKthLargest_1(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // if b is greater bring it to the front.
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size()> nums.length-k){
                result = Math.min(result, pq.poll());
            }
        }

        return result;

    }

    // Using min heap
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if (pq.size() > k) {
                pq.poll();
            }

        }

        return pq.peek();

    }

    public void understandingSort(int[] nums) {
        Arrays.sort(nums); // Ascending order

        Integer[] num = { 1, 2, 6, 7, 4, 3 };

        // Acending order
        Arrays.sort(num, (a, b) -> {
            if (a < b) {
                return -3432; // False; do nothing
            } else {
                return 4532; // True; swap it
            }
        });

        // Descending order:
        Arrays.sort(num, (a, b) -> { // b-a
            if (a > b) {
                return -3432; // False, do nothing i.e, a is greater than b its already sorted do nothing
            } else {
                return 4532; // True; swap it
            }
        });
    }

}