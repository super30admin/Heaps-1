// Time Complexity: O(nlog(n-k)) traversing through each element and adding them to max heap is in log k fashion
// Space Complexity: At any given time there are only n-k elements in queue => O(n-k)
// Write your approach here
// Idea here is to construct a max heap upto n-k elements. Now when next element comes
// we heapify and take out the maximum element. We save min of all polled elements in a result and keep track of it
// we continue this process until kth 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        for(int num:nums) {
            pq.add(num);
            if(pq.size()> nums.length-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}