// Time Complexity : O(n * log k), 
// Space Complexity :O(h), height of the tree which will be k elements in queue.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Maintain a min heap of size K, any element less than current k elements of heap,
// will not be part of largest kth element out of n

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // default -  minheap
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}

//Approach 2
// Time Complexity : O(n * log (n-k)), 
// Space Complexity :O(h), height of the tree which will be n-k elements in queue.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Maintain a max heap of size n-K. all smaller n-k elements will be in the pq.
// we need smallest among the remaining elements.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); // max heap
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            pq.add(nums[i]);
            if(pq.size() > n-k){
                result = Math.min(result, pq.poll());
            }
        }

        return result;
    }
}