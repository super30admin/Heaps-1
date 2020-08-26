/*
  Time: O(nlog(k))
  Space: O(1) since well only store max k elems at a goiven time.
  Run on LeetCode: yes
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ret = -1;

        if(nums.length == 0)
            return ret;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() == k){
                if(pq.peek() < num){
                    pq.poll();
                    pq.offer(num);
                }
            }
            else{
                pq.offer(num);
            }
        }

        return pq.poll();
    }
}
