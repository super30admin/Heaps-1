/**
 * SC : O(k) TC: O(n)
 * Approach : create min heap and push k elements, if size exceeds pop the element and add new element. 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}