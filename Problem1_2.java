//Time Complexity: O(n * log(n-k))
//Space Complexity: O(n-k)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public int findKthLargest(int[] nums, int k){
        
        if(nums == null|| nums.length == 0)
            return -1;
        int result = Integer.MAX_VALUE;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i =0; i < nums.length; i++){
            
            pq.add(nums[i]);
            
            if(pq.size() > nums.length -k){
                
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
