// Time Complexity : Nlogk
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//max heap nlog(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num); //logk
            if(pq.size() > n - k){ //logk
                result = Math.min(result,pq.poll()); //extract minimum
            }
        }
        return result;
    }
}


/*
//total time complexity nlogk
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num); //logk
            if(pq.size() > k){ //logk
                pq.poll(); //extract minimum
            }
        }
        return pq.peek();
    }
}
*/