import java.util.PriorityQueue;

/*
Time Complexity : O(N.log(k)), log k to insert values in the heap and N for inserting N elements in the heap
Space Complexity : O(k), k elements in the queue.
Did this code successfully run on Leetcode :
Any problem you faced while coding this :
Approach :
We can maintain a min heap of size k. As soon as size becomes more than k, we poll from the priority queue, which pops the min
value out. Once all values are entered, the pq has only k elements left. Where the top most of pq represent kth largest value
as n-k number of values that were smaller than the peek element have been popped out.
*/
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        // Kth largest is at the peek
        return pq.peek();
    }
}
