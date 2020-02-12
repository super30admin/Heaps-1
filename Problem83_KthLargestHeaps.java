//Time Complexity: O(log(n))
//Space Complexity: O(log(n))

class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        //creating heap by priority queue
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //iterating through array
        for(int i=0; i<nums.length; i++){  
            //adding all elements to my queue
            queue.add(nums[i]);     
        }
        //getting current of the queue
        int size = queue.size();
        //for elements total size of the queue - k elements
        for(int i=0; i< size-k; i++){
            //remove other than k elements from the queue
            queue.remove();
        }
        return queue.remove();
    }
}