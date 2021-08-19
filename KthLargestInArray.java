//Time Complexity : O(n logk), n -> Number of elements in the array, k -> Given k
// Space Complexity : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        
        //min heap
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num : nums) {
            pqueue.add(num);
            if(pqueue.size() > k)
                pqueue.poll();
        }
        return pqueue.peek();
        
        //max queue
        // PriorityQueue<Integer> mqueue = new PriorityQueue<>((a,b) -> (b-a));
        // int result = Integer.MAX_VALUE;
        // for(int num : nums) {
        //     mqueue.add(num);
        //     if(mqueue.size() > nums.length - k)
        //         result = Math.min(mqueue.poll(), result);
        // }       
        // return result;
    }
}
