// Time complexity - Minheap - O(nlogk), MaxHeap - O(nlog(n-k))
// space complexity - MinHeap - O(k), maxHeap - O(n-k)
// Solved on leetcod e- yes
// faced any issues - No
// In Minheap, the smallest elements will always be stored in the top and (n-k) smallest elements will come out, so the we can have k largest elements in the queue and then the top most will be the resultant.
// In maxHeap solution, we are having n-k elemnets in the heap and removing the lasrgest k elements of the array and chceking the minimum element of the removed elements
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Using MinHeap - Queue size must be k
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for(int i : nums) {
        //     minHeap.add(i);
        //     if(minHeap.size() >k) {
        //         minHeap.poll();
        //     }
        // }
        // return minHeap.peek();

        // Using MaxHeap - Queue Size must be (n-k)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        int result = Integer.MAX_VALUE;
        for(int i: nums) {
            maxHeap.add(i);
            if(maxHeap.size()>nums.length-k) {
                result = Math.min(result, maxHeap.poll());
            }
        }
        return result;
        }
}
