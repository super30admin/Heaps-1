class Solution {
    /*
        TC - O(n log k)
        SC - O(k)
        Solution - Use a min heap to keep track of the k largest elements.
        Iterate through each number in nums:
            Add the number to the heap.
            If the heap size becomes greater than k, remove the smallest element.
            After processing all elements, the heap contains exactly the k largest numbers.
            The smallest number in this heap is the Kth largest element, so return pq.poll().
    */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}