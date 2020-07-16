//Time complexity=O(N log (n-k))
//Space complexity=O(n-k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        // int[] result = new int[k];
        // int x = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){//nlog(n-k)
            pq.add(nums[i]);
            if(pq.size() > (nums.length - k)){
                // result[x] = pq.poll();
                // x++;
                min = Math.min(min, pq.poll());
            }
        }
        
        // Arrays.sort(result);
        return min;
    }
}