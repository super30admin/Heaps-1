package Heaps1;

import java.util.PriorityQueue;

/*
   -------------------------------------------------------------------------------------------------------
   Time complexity : n log(n-k) -since for each elenent added to priority queues, max  heapify function is called for n-k elements
   space complexity: o(n-k) - size of priority queue
   Did this code run successfully in leetcode : yes
   problems faces : no*/

public class KthLargestElementMaxHeap {
    
 public int findKthLargestWithMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer>  pq = new PriorityQueue<>((a,b)-> b-a); //mac heap
       // PriorityQueue<Integer> pq = new PriorityQueue<>();
        int kthLargetstNumber = Integer.MAX_VALUE;
         
        for(int num: nums)
        {
            pq.add(num);  //log n-k -- applies max heap for n- k elements
            if(pq.size()> nums.length-k)
            {
               int element = pq.poll(); //log n-k - max heapify function called on remaining set of elements
               kthLargetstNumber = Math.min(kthLargetstNumber, element);
            }
        }
     
         return kthLargetstNumber;
    }
 
 
}
