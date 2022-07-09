class Solution {
    // Heap(Priority Queue) 
    // Min heap TC O(nlog(k)), 1 <= k <= nums.length <= 10**4 ie. it is better than array sort O(nlog(n))
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:nums){
            pq.add(num);
            if (pq.size()>k){
                pq.poll(); //Remove minimum(root since it is min heap), heapify
                // System.out.println(pq);
            } 
        }
        return pq.peek(); //First element of the queue, peek gives the head
    }
}
    
/*
    public int findKthLargest(int[] nums, int k) {
    // Max heap TC O(nlog(n-k)) > Min heap TC O(nlog(k)) because k is usually much smaller than n
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // custom comparator to make max heap
        int result = Integer.MAX_VALUE;
        for (int num : nums){
            pq.add(num);
            if (pq.size() > n-k){
                System.out.println(pq);
                result = Math.min(result,pq.poll());
            } 
        }
        return result;
    }
*/
    
    
