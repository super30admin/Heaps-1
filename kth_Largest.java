class Solution {
    //Time O(klogk)
    //Space O(k)
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> a-b);
        for(int i = 0 ; i < nums.length ; i++)
        {
            PQ.add(nums[i]);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
        }
        return PQ.peek();
    }
}