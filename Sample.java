//****Kth largest element in an array****
//Time complexity:nlogk where n is the size of array and k is the size of heap
//Space complexity:0(k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            //If size exceeds perform pop;
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
