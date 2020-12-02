TC: O(n)
TC: O(n)

32 / 32 test cases passed.
Status: Accepted
Runtime: 6 ms
Memory Usage:



class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        return minHeap.remove();
    }
}
