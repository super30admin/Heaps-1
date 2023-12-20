/*
Approach : Max Heap based Solution
for n elements, we have Max heap of size n-k only, so if size> n-k we extract elements. 
once we are exhausted with nums array, the element hanging in our result variable is the kth largest answers, as we have already removed k+1to n  bigger elements.
 
 tc: O(n log n-k)
 sc: O(n-k)
    */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return -1;

        int len = nums.length - k;
        int result = Integer.MAX_VALUE;

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int n : nums) {
            pq.add(n);

            if (pq.size() > len) {
                result = Math.min(pq.poll(), result);
                System.out.println("Removeed " + result);
            }

        }

        // the last extraction is the answer
        return result;
    }
}

/*
 * Approach : Min Heap based Solution
 * for n elements, we hve min heap of size k only, so if size>k we extract
 * elements.
 * once we are exhausted with nums array, the element hanging on top as a
 * Minimum is our kthe largest answers, as we have already removed 0 to k-1
 * smaller elements.
 * 
 * tc: O(n log k)
 * sc: O(k)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return -1;

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int n : nums) {
            pq.add(n);

            if (pq.size() > k)
                pq.poll();
        }

        // the last extraction is the answer
        return pq.poll();
    }
}