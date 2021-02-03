// Time Complexity : O(nlogk) n is size of array
// Space Complexity : O(k) to store heap
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((m, n) -> n - m);
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        return minHeap.poll();
    }
}
