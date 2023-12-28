// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //MaxHeap
    PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
    int result= Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        pq.add(nums[i]);

        if(pq.size()>nums.length-k)
        {
           int j= pq.poll();

            result= Math.min(result,j);
        }
    }
    return result;




        //MinHeap
        // PriorityQueue<Integer> pq= new PriorityQueue<>();

        // for(int i=0; i<nums.length;i++)
        // {
        //     pq.add(nums[i]);
        //     if(pq.size()>k)
        //     {
        //         pq.poll();
        //     }
        // }
        // return pq.peek();
    }
}