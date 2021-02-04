Time Complexity: o(n) log k
Space Complexity: o(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0;  i< nums.length; i++)
        {
            if(q.size() < k)
            {
                q.add(nums[i]);
            }
            else if(nums[i] > q.peek()){
                q.poll();
                q.add(nums[i]);
            }
        }
        return q.poll();
    }
}