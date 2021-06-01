class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        int result = Integer.MAX_VALUE;
        for(int n : nums)
        {
            heap.add(n);
            if(heap.size() > nums.length - k)
            {
                result = Math.min(result, heap.remove());
            }
        }
        return result;
    }
}
