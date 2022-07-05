// Time complexity: O(nlogk)
// space complexity: O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num); // 5,6
             System.out.println(pq);
            if(pq.size() > k){
                System.out.println(pq.poll());
                
            }
        }
        return pq.peek();
    }
}
