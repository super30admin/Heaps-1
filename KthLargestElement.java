//Using MaxHeap
//TC: O(n log (n-k)) SC: O(n-k)

//Using Min-Heap
//TC: O(n logk) SC: O(k)

//n is the length of input array
//k is the given kth value

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Using Min-Heap
//TC: O(n logk) SC: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}

//Using MaxHeap
//TC: O(n log (n-k)) SC: O(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            pq.add(num);

            if(pq.size() > n-k){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}
