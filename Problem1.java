// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a - b);
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(queue.size() > k){ // at any point the size goes above k ,remove one element
                queue.remove();
            }

        }
        if(!queue.isEmpty()){
            return queue.peek();
        }
        return 0;
    }
}

