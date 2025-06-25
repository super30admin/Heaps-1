/*
  Time complexity: O(n*log k(
  Space complexity: O(k)

  Code ran successfully on Leetcode: Yes

*/

public class Solution {
    public int FindKthLargest(int[] nums, int k) {
        PriorityQueue<int,int> pq = new();
        int i=0;
        while(i<nums.Length)
        {
            pq.Enqueue(nums[i],nums[i]);
            if(pq.Count>k)
                pq.Dequeue();

            i++;
        }
        return pq.Dequeue();
    }
}
