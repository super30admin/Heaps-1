// Time Complexity : O(N log K)
// Space Complexity : O(K)  for minheap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Solution {
    public int FindKthLargest(int[] nums, int k) {

        PriorityQueue<int,int> minHeap = new PriorityQueue<int,int>();

        foreach(int num in nums){
            minHeap.Enqueue(num, num);
            if(minHeap.Count > k){
                minHeap.Dequeue();
            }
        }
        return minHeap.Peek();
    }
}
