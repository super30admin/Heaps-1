// Time complexity - O(nlogk)
// Space complexity - O(k)
// Min heap Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k ){
                pq.poll();
            }
        }
        return pq.peek();
    }
}


// Time complexity - O(nlog(n-k))
// Space complexity - O(n-k)
// Max heap Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            pq.add(n);
            if(pq.size() > nums.length - k ){
                int m = pq.poll();
                min = Math.min(min,m);
            }
        }
        return min;
    }
}
