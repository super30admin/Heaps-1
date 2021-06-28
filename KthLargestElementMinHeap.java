package Heaps1;

import java.util.PriorityQueue;

/*
   -------------------------------------------------------------------------------------------------------
   Time complexity : n log k - for each elements of n, k elements added to priority queue and  heapify function is called for k elements
   space complexity: o(k) - max size of priority queue
   Did this code run successfully in leetcode : yes
   problems faces : no*/

public class KthLargestElementMinHeap {
    
 public int findKthLargestWithMinHeap(int[] nums, int k) {
        PriorityQueue<Integer>  pq = new PriorityQueue<>(); //minheap (a,b)->a-b this default
        
        for(int num: nums)
        {
            pq.add(num);  //log k -- aplies min heap for k elements
            if(pq.size()>k)
            {
                pq.poll(); //log k - heapify function called on remainin set of elements
            }
        }
     
         return pq.peek();
    }

}
