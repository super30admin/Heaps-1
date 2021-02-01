class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i=0;i<nums.length;i++){
           pq.add(nums[i]);
       }
       while(nums.length-k>0){
           pq.poll();
           k++;
       }
        return pq.peek();
    }
}

//Time complexity : O(N) where n is the number of elements in nums
//Space complexity : O(N)
