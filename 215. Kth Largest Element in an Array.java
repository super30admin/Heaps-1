class Solution {
    // Time complexity: O(Nlogk)
    // Space complexity: O(k)
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        // or we are sorting the elements by asceding order
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((a, b) -> a - b);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.peek();        
  }
}