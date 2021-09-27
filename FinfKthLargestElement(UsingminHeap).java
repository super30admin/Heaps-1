
// Time Complexity :O(nlogn)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// using min heap -- > smallest element will be at head of pq
// 1. take a priorityQueue of size =k . keep adding all elements  but poll out pq whene pq size is more than k
// 2. this way at the end head of pq will be the  kth largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int secondLargestElement = Integer.MIN_VALUE;
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size() >k)
            {
                pq.poll();
            }
        }
        return  pq.poll();
    }
}