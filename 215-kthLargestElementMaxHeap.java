/**LC-215
 * 
 * Time Complexity : O(nlog(n-k))  k: k n-> nums.length
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Algorithm:
 * 1. We create a max heap and maintain a size n- k/ We maintain a result variable and compare the popped element and store the min of them into it.
 * 2. When size exceeds n-k, we poll the element.
 * 3. Likewise, we continue till we process the whole nums array.
 * 4. At last, return result variable.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);  //max heap
        int result = Integer.MAX_VALUE;
        int poppedElement = 0;
        int n = nums.length;
        for(int num: nums){
            
            pq.add(num);
            if(pq.size() > n - k){
                poppedElement = pq.poll();
                if(poppedElement < result)
                    result = poppedElement;
            }
        }
        /** OR in the for loop we can write
         * pq.add(num);
            if(pq.size() > n - k){
                
                result = Math.min(pq.poll(), result);
            }
         */
        return result;
    }
}