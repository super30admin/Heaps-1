//Time Complexity : O(n *log(k))
//Space Complexity : O(k)
//Code run successfully on LeetCode.

public class Problem1_1 {

public int findKthLargest(int[] nums, int k) {
        
        if(nums == null|| nums.length == 0)
            return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0; i < nums.length; i++){
            
            pq.add(nums[i]);
            
            if(pq.size() > k)
                pq.poll();
            
        }
        
        return pq.poll();
        
    }
}
