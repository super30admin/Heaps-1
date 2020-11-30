
/**LC-215
 * 
 * Time Complexity : O(nlogk)  k: k n-> nums.length
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Algorithm:
 * 1. We create a min heap and maintain a size k.
 * 2. When size exceeds k, we poll the element.
 * 3. Likewise, we continue till we process the whole nums array.
 * 4. At last, the root element is the kth largest element
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //min heap
        
        for(int n: nums){
            
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}