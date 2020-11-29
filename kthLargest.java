//kth largest element using minheap

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            int a = pq.size();
            if(pq.size() > k){
                int a1 = pq.poll();
            }
        }
        return pq.peek();
    }
}