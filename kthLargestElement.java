class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for(int num : nums){
            pq.add(num);
            if(pq.size() > n-k){
                int poll = pq.poll();
                result = Math.min(result,poll);
            }
        }
        return result;
    }
}





/*

TC : O(n log k )

SC : O(k)

Description : We can do in both min heap and max heap if use this "(a,b)->a-b" then its min heap. If we use this "(a,b)->b-a" then its max heap.

If it is max heap then we need to check PQ size > n-k and comparing every max element 




 */