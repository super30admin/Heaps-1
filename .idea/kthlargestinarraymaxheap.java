// Time Complexity : O(n * log(n-k)) where n is nums.length
// Space Complexity : O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Integer[] num = {1,2,6,7,4,3};
    // Arrays.sort(num, (a,b) -> { //(a,b) -> a - b //For asc, 1-2 return negative value hence does not swap and the order remains unchanged. //For desc, 2-1 return positive value hence swaps the order and the order is now desc.
    // if(a < b){
    //     return -3434; //False don't do anything
    // } else{
    //     return 4354; //True swap it
    // }

    public int findKthLargest(int[] nums, int k) {
        int result = Integer.MAX_VALUE; //Initiate the result with the max value
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); //Initiate max heap with the comparator
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]); //Add every elem to the heap
            if(pq.size() > nums.length - k){ //If the size exceeds n - k
                result = Math.min(result, pq.poll()); //Find the minimum between the elem that exceeds n-k size and the already present value in result
            }
        }
        return result;
    }
}