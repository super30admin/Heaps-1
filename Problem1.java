//Time complexity: O(n log(n-k))
//Space complexity: O(n-k)
class Solution {
    //max heap
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
       int result=Integer.MAX_VALUE;
       for(int num : nums){
           pq.add(num);
           if(pq.size()> nums.length - k){
               result = Math.min(result, pq.poll());
           }
       }
        return result;
    }
}