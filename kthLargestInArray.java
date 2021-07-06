// Time Complexity : O(Nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope

// Maintain a Min Heap and keep on adding the elements to the min heap
// The momnent the size of the min heap becomens more than k, remove and element from the min heap
// Return the top most element from the min heap as it will be the k-th largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int n: nums){
            minHeap.add(n);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        
        result = minHeap.remove();
        
        return result;
    }
}
