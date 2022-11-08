package s30.Heaps-1;

public class problem1 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //TC:- O(nlog(n-k))
            //SC:- O(k)
            if(nums == null || nums.length == 0)  return -1;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
            int result = Integer.MAX_VALUE;
            
            //max heap sol
            for(int num : nums){
                pq.add(num);
                if(pq.size() > (nums.length - k)){
                    result = Math.min(result,pq.poll());
                }
            }
            
            return result;
        }
    } 
}
