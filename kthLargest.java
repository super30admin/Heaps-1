// time complexity = O(nlog(k))
// space complexity = O(k)

// using max heap

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);// max heap.
        for(int i=0;i< nums.length;i++) {
            pq.add(nums[i]);
            if(pq.size()>(nums.length-k+1)) {
                pq.poll();
            }
            
        }   
        return pq.peek();
    }
}

// using min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();// min heap.
        for(int i=0;i< nums.length;i++) {
            pq.add(nums[i]);
            if(pq.size()>k) {
                pq.poll();
            }
            
        }
        return pq.peek();
    }
}