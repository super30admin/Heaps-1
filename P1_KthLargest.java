// TC: O(nlogk)
// SC: O(K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (a-b));
        int i=0;
        while(k!=0) {
            pq.add(nums[i]);
            i++;
            k--;
        }
        for(int j=i ; j<nums.length ; j++) {
            pq.add(nums[j]);
            pq.remove();
        }
        return pq.peek();
    }
}