// ## Problem1 
// Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

class Solution {
    // 1. Using min-heap
    // Time: O(N logk), where N is the number of input elements
    // Space: O(k)
    private int minHeap(int[] nums, int k){
        // Maintain a min-heap of size k throughout
        // Add elements from nums
        // At the end, the heap will have the k largest elements,
        // with kth largest at top

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    //2. Using max-heap
    // Time: O(N log(N-k+1))
    // Space: O(N-k+1)
    private int maxHeap(int[] nums, int k){
        // max-heap always return the largest element
        // We want our kth largest element at the top of heap
        // We need to remove the initial k larger elements
        // For that we need a heap of size (N-k+1)
        // After we are done processing all the elements, top of heap will give the kth largest

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
            if(pq.size()>(nums.length-k+1)){
                pq.poll();
            }
        }

        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        //return minHeap(nums,k);
        return maxHeap(nums,k);
    }
}