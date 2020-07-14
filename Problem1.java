//time o(nlogk)
//space o(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return -1;
        
        //by default it's comparator is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            if(pq.size() < k){
                pq.add(nums[i]);
            }
            else {
                if(pq.peek() < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}