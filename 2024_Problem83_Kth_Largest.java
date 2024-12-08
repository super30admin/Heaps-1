//215. Kth Largest element in an Array - https://leetcode.com/problems/kth-largest-element-in-an-array/description/
//Time Complexity: O(n*log(k))
//Space Complexity: O(k)

//MinHeap - Optimal
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //default is MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            //add all elements to priorityqueue
            pq.add(num);
            //if size>k, poll the min element of heap
            if(pq.size() > k){
                pq.poll();
            }
        }
        //return top most element - kth
        return pq.peek();
    }
}

//MaxHeap
//Time Complexity: O(n*log(n-k))
//Space Complexity: O(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            //add all elements to priorityqueue
            pq.add(num);
            //if size>n-k, poll largest elements
            if(pq.size() > nums.length - k){
                //among the larger elements polled out, min is the result
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}