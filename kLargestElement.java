
//Passed test cases on LeetCode

class Solution {
    //O(nlogk) - Time complexity ; O(k) - Space complexity
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i:nums){
            pq.add(i);
            if(pq.size() > n-k)
            {
                res = Math.min(res, pq.poll());
            }
        }
        return res;
        
    }
}
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
            
        }
        return pq.peek();
        */
