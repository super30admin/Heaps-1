//TC: O(n log k) - heapify happens on k elements
//SC: O(k)
//Using min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

//Using max heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num: nums){
            pq.add(num);
            if(pq.size() > n-k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}
