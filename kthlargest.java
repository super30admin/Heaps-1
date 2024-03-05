// Time Complexity :O(nlog k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: use a priority queue keep ading all the elements if we want kth larges then we restict the size to k then check if it is the largest of k elements if not then remove and nat the end whatever is at the top of queue is the kth largest element

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< n; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}