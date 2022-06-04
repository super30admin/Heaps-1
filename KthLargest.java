/**

Time complexity: O(nlogk)
Space complexity: O(k)

 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            p.add(nums[i]);
            if(p.size()>k){
                p.poll();
            }
        }
        return p.peek();
    }
}