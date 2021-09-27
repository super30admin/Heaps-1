
// Time Complexity :O(nlogn)
// Space Complexity :O(n-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// using min heap -- > smallest element will be at head of pq
// 1. take a priorityQueue of size = n- k . keep adding all elements  but poll out pq whene pq size is more than n-k
// 2. this way at the end head of pq will be the  kth largest element


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        int result = Integer.MAX_VALUE;
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size() >nums.length-k)
            {
               result =  Math.min(result,pq.poll());
            }
        }
        return  result;
    }
}