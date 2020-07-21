// Time Complexity : O(n logk)  n is number of elements in array
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//MinHeap
//create a minheap of size k
//after iterating all the elements in the list
//the kth largest element is on top of the heap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.offer(nums[i]);
            }
            else{
                if(nums[i]>pq.peek()){
                    pq.remove();
                    pq.offer(nums[i]);
                }
            }
            
        }
        
        return pq.remove();
        
    }
}