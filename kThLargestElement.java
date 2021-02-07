// Time Complexity : O(nlogk) Min Heap O(nlog(n-k)) Max Heap
// Space Complexity : O(k) at a time heap can have max k elements in Min Heap solution
//O(n-k) for max heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Maintain (arr.length - k) elements in max Heap
//At the end, the kth largest element will be at the top of the heap

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); //min heap
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > nums.length - k + 1)
                pq.poll();
        }

        /**
        PriorityQueue<Integer> pq = new PriorityQueue(); //min heap
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }**/
        return pq.peek();
    }
//Min Heap Solution, keep k elements in the queue.
//At the end, the kth largest element will be at the top of the heap.
    public int findKthLargest(int[] nums, int k) {


        PriorityQueue<Integer> pq = new PriorityQueue(); //min heap
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}
