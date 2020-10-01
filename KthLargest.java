// Time Complexity : O(nlogk) 
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Implemented minheap using the priority queue 
//removing elements first n-k elements from min heap to reach to your kth largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int num:nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}