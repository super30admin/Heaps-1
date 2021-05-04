/*

Thought Process: Use min heap to find Kth largest.
    -> Use a min heap priority queue and loop through the nums
    -> Add to the queue and if the queue size goes above K, poll q which will return the top smallest number
    -> Numbers smaller than top won't go in the min heap

Time Complexity - O(N) -> Looping through all the elements only once
Space Complexity - O(K) -> Maximum size of min heap will be k

*/

class kthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        
        // Min Heap Approach
        if(nums.length == 0 || nums == null) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n: nums){
            minHeap.add(n);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
        
        /*
        // Max Heap Approach
        
        if(nums.length == 0 || nums == null) return -1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        Integer min = Integer.MAX_VALUE;
        for(int n: nums){
            maxHeap.add(n);
            if(maxHeap.size() > nums.length-k)
                min = Math.min(maxHeap.poll(), min);
        }
        return min;
        
        */
    }
}