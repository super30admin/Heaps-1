// O(n log k) time complexity
//O(k) is the space complexity 

class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

       for(int i = 0 ; i < nums.length ; i ++){
        queue.add(nums[i]);
        if(queue.size() > k){
            queue.poll();
        }
       }

       return queue.peek();

    }
}
