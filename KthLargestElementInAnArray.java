// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int result = 0;
        for(int num : nums) {
            pq.add(num);
        }

        // Object[] arr = pq.toArray();
        // System.out.println(Arrays.toString(arr));

        for(int i = 0; i<k; i++) {
            result = pq.poll();
        }

        return result;
    }
}*/

class Solution {
  public int findKthLargest(int[] nums, int k) {
    // Ascending order sorting
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i<nums.length; i++) {
      pq.add(nums[i]);
      if(pq.size() > k) {
        // Remove the smallest
        pq.poll();
      }
    }
    // Smallest element left
    return pq.peek();
  }
}