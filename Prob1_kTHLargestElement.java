//Max - Heap
// Time Complexity : O(N * Log(N-K))
// Space Complexity : O(N-K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a); //Using Max-Heap
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            queue.add(n);
            if(queue.size() > nums.length-k){ // Kth largest element will be the minumum of Topmost K elements 
                min = Math.min(min, queue.poll()); // So keeping heap of size n-k
            }
        }
        return min;
    }
}

/*



//Min - Heap
// Time Complexity : O(N * Log(K))
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n : nums){
            queue.add(n); // Adding element in MinHeap
            if(queue.size() > k){ // If heap size > k, remove element from the Queue
                queue.poll();
            }
        }
        
        return queue.poll();//At the end, top element in heap will give kth largest element
    }
}




*/