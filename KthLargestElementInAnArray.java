//time - O(nlogk)
//space - O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.poll();
    }
}
