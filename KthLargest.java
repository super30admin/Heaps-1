/*
 * 
 * Time Complexity : O(n*log k)
 * Space Complexity  : O(k)
 * 
 */
class Solution {
	
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<k; i++){
            queue.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            
            if(queue.peek() < nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        
        return queue.peek();
        
    }
}