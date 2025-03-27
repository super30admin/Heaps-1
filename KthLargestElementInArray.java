import java.util.PriorityQueue;

//Time Complexity : O(nlogk)
//Space Complexity : O(n-k) for heap
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class KthLargestElementInArray {
    //max heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i:nums){
            pq.add(i);
            if(pq.size()>n-k){
                int top = pq.poll();
                min=Math.min(min,top);
            }
        }
        return min;
    }
}