//Time Complexity: O(NLogK)
//Space Complexity: O(K)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Maintaining MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        int n = nums.length;
        // after we insert the first k elements - starting from ascending values
        // we keep track of whatever comes after that, taking max out of it
        int result = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            // we keep inserting values into heap
            pq.add(nums[i]);
            // when pq reaches the length of k,
            // we take the min out of the top of the heap
            // add it to our result if result is less than the tip of heap
            // that we ensure we take kth largest
            if(pq.size() == k) {
                result = Math.max(pq.poll(), result);
            }
        }
        return result;
    }
}