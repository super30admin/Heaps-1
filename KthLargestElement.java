class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num: nums){
            //add num to the min Heap
            minHeap.add(num);
            
            //if min heap exceeded limit them remove the top element
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        //top element on min heap will be the kth largest element on the array
        return minHeap.poll();
    }
}
//Time Complexity: O(n)
//Space Complexity: O(k)