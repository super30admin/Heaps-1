//Priority Queue 

//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: nums){
            pq.add(n);
            if(pq.size()> k){
                pq.poll();
            }
        }
        return pq.peek();       
    }
}

//Min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for (int n: nums){
            pq.add(n);
            if(pq.size()> k){
                pq.poll();
            }
        }
        return pq.peek();       
    }
}

//MAx heap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        int min= Integer.MAX_VALUE;
        for (int n: nums){
            pq.add(n);
            if(pq.size()> nums.length- k){
                min= Math.min(min, pq.poll());
            }
        }
        return min;       
    }
}