/*
Brute force solution is just sort an array in O(nlogn) time and return the array[len-k] element in O(1) time that willa kth largest elenement

Optimized solution
The idea is to init min heap with size k and keep inserting element in an array to min heap, keeping size of heap always less than k. 
If size goes beyond k I would be removing the top element 
I would use minheap because as we wanted k largest element, I need to get rid of smaller elements and with the min heap I will be having access to smaller elements. 
*/
PriorityQueue<Integer>pq;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //min heap
        pq = new PriorityQueue<Integer>(k, (a,b) -> a-b);
        for(int i : nums){
            pq.add(i);
            //If size goes beyond k I would be removing the top element from the heap. 
            if(pq.size()>k)
                pq.poll();
        }
        return pq.remove();
    }
}
