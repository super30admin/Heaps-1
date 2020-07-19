// Time Complexity : nlogk
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//MinHeap
//create a minheap of size k
//after iterating all the elements in the list
//the kth largest element is on top of the heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        //Custom comparator for MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();     
    }
}


/////////////////

// Time Complexity : n - klog(n-k)
// Space Complexity : n-k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//MaxHeap
//create a maxheap of size n-k
//after iterating all the elements in the list
//and kth n-kth min element of the list
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        //Custom comparator for MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0; i < n; i++) {
            pq.add(nums[i]);
            if(pq.size() > n-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;   
    }
}
