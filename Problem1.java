//https://leetcode.com/problems/kth-largest-element-in-an-array/
//Time complexity : O(NlogN)
//Space complexity : O(K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int e : nums){
            if(q.size() < k){
                q.add(e);
            }
            else if(q.peek() < e){
                q.poll();
                q.add(e);
            }
        }
        return q.poll();
    }
}





