/*
 * #215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
You may assume k is always valid, 1 <= k <= array's length.

 */


/*
 * Time Complexity: O (n.logk) -> 'n' to traverse through elements of unsorted array and insert in min heap, 'logk' to heapify the min heap elements (N-K) times after removing smallest elements 
 * 
 * Space Complexity: O (N) -> 'N' elements are stored in a priority queue - min heap, not all at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.heaps1;

import java.util.PriorityQueue;

public class KLargestElement {
	public int findKthLargest(int[] nums, int k) {
        // nums[] = [3,2,3,1,2,4,5,5,6]
        // sorted = [1,2,2,3,3,4,5,5,6]
        // sorted array is used to show removal of first 5 smallest elements from min heap
        
        // #1. Base case
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        // #2. Using Min Heap as a Priority Queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        /*
        * We will remove (N-K) = 9 - 4 = 5 smallest elements from the input array to get 6th number as the kth largest value in an unsorted array
        * 1. Traverse through the array and insert elements from unsorted array in a min heap(priority queue)
        * 2. As soon as the size of priority queue becomes > k, start removing the first (N-K) smallest elements from priority queue(min heap) one by one
        * After removing a smallest element from min heap, keep adding the rest elements from unsorted array to priority queue until array is out of bounds. Once, priority queue size becomes > k, the process of removing the smallest element and adding next element in unsorted array happens parallely until we have removed first (N-K) smallest elements and array has reached out of bounds.
        * Once we are out of bounds, we have our kth largest element at the root of min heap
        * Exit the for loop for traversing input array, and remove the root of min heap(kth largest element) and return it
        * 
        */
        
        // #3. Traverse thorugh the array to find kth largest element in unsorted array
        for(int num : nums){
            
            // After adding element in min heap, fix the heap if required to satisfy min heap properties
            minHeap.add(num);
            
            if(minHeap.size() > k){
                // After removing element from min heap, fix the heap if required to satisfy min heap properties
                minHeap.remove();
            }
            
        }
        
        // Once, array goes out of bounds, return the root of min heap which is our answer
        return minHeap.remove();
        
    }
	
}
