// Time Complexity : O(n * log(k)) where n is nums.length
// Space Complexity : O(k)
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
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Initialize the min heap(default)
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]); //Add all the elem to the heap and then check the size
            if(pq.size() > k){ //If the size of the heap is greater than k
                pq.poll(); //Pop out the last elem in pq
            }
        }
        return pq.peek(); //Return the last elem
    }
}