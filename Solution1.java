import java.util.*;


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach

// Time Complexity : O(nlogn)(time required to sort the array )
// Space Complexity :O(1) no extra space required
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
            Arrays.sort(nums);
        return nums[nums.length-k];
    }

//Min Heap solution
// Time Complexity : O(klogk)(ttime required to put k elements in priority queue )
// Space Complexity :O(k) space required for priority queue
    public int findKthLargest1(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

//Max Heap solution
// Time Complexity : O(n-klog(n-k))(ttime required to put k elements in priority queue )
// Space Complexity :O(n-k) space required for priority queue
    public int findKthLargest2(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int n:nums){
                pq.add(n);
            if(pq.size()>nums.length-k+1){
                pq.poll();
            }
        }
        return pq.peek();
    }
}