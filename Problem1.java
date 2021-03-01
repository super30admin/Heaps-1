// Time Complexity :O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int findKthLargest(int[] nums, int k) {//adding k number to minheap
        PriorityQueue<Integer> minheap= new PriorityQueue<Integer>();
        int count=0;
            for(int n: nums){
                minheap.add(n);
                if(minheap.size()>k){
                      minheap.poll();
                        count++;
                }
            }
            if(count==nums.length-k)//n-k smallest numbers are retrieved and we are at kth largest number
                return minheap.poll();

        
        return -1;
        
    }
}