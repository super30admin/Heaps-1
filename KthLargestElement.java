public class KthLargestElement {

  /**
   * 
   * Time Complexity: O(k log k)
   * 
   * Space Complexity: O( log k)
   * 
   * Were you able to solve this on leetcode? Yes
   * 
   */
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    for(int i = 0; i < nums.length; i++){
        pq.add(nums[i]);

        if(pq.size() > k){
            pq.remove();
        }
    }
    
    return pq.poll();
}
}
