//Time Complexity: O(nlogk)
//Space Complexity: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        for(int i=0; i<nums.length;i++){
            largest.add(nums[i]);
            if(largest.size()>k){
                largest.poll();
            }
        }
        
        return largest.poll();
    }
}