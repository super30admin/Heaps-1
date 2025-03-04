//Time complexity:- O(n logk) where k is number of elements in heap
//Space complexity:- O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //if it is largest element then use min heap
        //if it is smallest element use max heap
        for(int i: nums) {

            minHeap.add(i); //log k

            //we need to make sure kth largest element is at top
            if(minHeap.size() > k) {
                minHeap.poll(); //log k
            }
        }
        
        return minHeap.poll();
    }
}
