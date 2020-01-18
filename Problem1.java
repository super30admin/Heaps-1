// Time Complexity - O(nlogk) logk is the time complexity to sort in the min heap and n is the number of elements in the array. 
// Space Complexity - O(k+1) At a time there will be k+1 elements in the heap(priority queue). The size of the min Heap is K+1
// This Solution worked on LeetCode
// To find the kth largest element , we would be using min heap(priority queue) to add the array elements upto k+1, and poll the top of the Heap which would be the minimum element on the heap. At the end of the array traversal, the heap will be left with k elements with kth largest element at its top. So, we return the top of the heap as the kth largest element. 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for(int i =0; i < nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}
