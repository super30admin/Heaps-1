//time o(nlogk)
//space o(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> a-b);
        for(int i : nums) {
            pq1.add(i);
            if(pq1.size() > k) {
                pq1.poll();
            }
        }
        return pq1.poll();
    }
}
