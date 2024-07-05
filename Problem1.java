// Time Complexity : o(n logk)
// Space Complexity : o(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach -1 - Using MIN HEAP

// Your code here along with comments explaining your approach
// Use a min-heap (priority queue) to keep track of the largest k elements in the array.
//Iterate through each element in the array, adding it to the heap and removing the smallest element if the heap size exceeds k.
//The root of the heap will be the kth largest element in the array.

class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        PriorityQueue<Integer> pq = new  PriorityQueue<>();
        int n = nums.length;
        for(int i =0; i<n ; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// Approach-2 - using MAX HEAP

// Use a max-heap to store the elements of the array with the largest elements at the top.
// Iterate through each element in the array, adding it to the heap and removing the largest element if the heap size exceeds n-k.
// The minimum of the removed elements will be the kth largest element in the array.

class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        PriorityQueue<Integer> pq = new  PriorityQueue<>((a,b)-> b-a);
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i =0; i<n ; i++){
            pq.add(nums[i]);
            if(pq.size() > n-k){
                min = Math.min(min, pq.poll());
            }
        }
        return min;
    }
}