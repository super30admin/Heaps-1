class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        Queue<Integer> q = new PriorityQueue<>();

        for(int num: nums){
            if(q.size() < k){
                q.offer(num);
            } else if(q.peek() < num){
                q.poll();
                q.offer(num);
            }
        }

        return q.peek();
    }
}
