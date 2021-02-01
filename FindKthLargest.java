// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for(int num:nums){

            // Add the number in the queue till its size is equal to k
            if(q.size() < k){
                q.offer(num);
            }
            else{
                // If the first element in the queue is less than the current number, poll and then add the current number
                if(num > q.peek()){
                    q.poll();
                    q.offer(num);
                }
            }
        }

        return q.poll();
    }
}