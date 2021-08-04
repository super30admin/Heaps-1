// Time Complexity : O(Nlogk) N-> No of Elements
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Min Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0 ) return Integer.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int result = Integer.MAX_VALUE;

        for(int n : nums){
            pq.add(n);

            if(pq.size() >  k){
                pq.poll();
            }

        }

        return pq.poll();

    }
}

// Max Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0 ) return Integer.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int result = Integer.MAX_VALUE;

        for(int n : nums){
            pq.add(n);

            if(pq.size() > nums.length - k){
                result = Math.min(pq.poll(), result);
            }

        }

        return result;

    }
}