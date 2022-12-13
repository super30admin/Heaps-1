class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int result = Integer.MAX_VALUE;

        for(int num : nums){
            pq.add(num);
            if(pq.size() > n - k){
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }
}

//TC: O(n log (n - k))
//SC: O(n-k)
