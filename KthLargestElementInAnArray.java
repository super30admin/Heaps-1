import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n*logk) where n = number of elements in array, k = given kth largest element
// Space Complexity : O(k) where k = size of heap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//215. Kth Largest Element in an Array (Medium) - https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) { // O(n*logk) where n = number of elements in array, k = given kth largest element
            pq.add(num);
            
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.poll();
    }
}