// Time Complexity : O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        for(int num : nums) {
            pq.add(num);
            if(pq.size()>k)
                pq.poll();
        }
        
        return pq.poll();
    }
}
