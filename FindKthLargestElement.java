//Time Complexity: O(NlogN-k)
//Space Complexity: O(N-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {

        //Declare Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int res = Integer.MAX_VALUE;

        for(int num: nums)
        {
            pq.add(num);

            if(pq.size() > nums.length-k){
                res = Math.min(res, pq.poll());
            }
        }

        return res;
    }
}