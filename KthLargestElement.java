import java.util.PriorityQueue;

// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

//Time complexity:- O(n logk) where k is number of elements in heap
//Space complexity:- O(k)

//In this approach, we take a Priority Queue(min-heap) of size k and we keep adding all the elements in the array into the priority queue.
//We remove the elements from the start if the set priority queue of size k becomes full.
//Once all elements are inserted, the kth largest element will be at the start of the priority queue.

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int num : nums) {
            pq.add(num); // logk

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}