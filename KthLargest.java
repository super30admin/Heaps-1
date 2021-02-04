/**

Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        for( int num: nums)
        {
            queue.add( num);
        }
        
        
        int count = 1;
        
        while( count < k)
        {
            queue.poll();
            count++;
        }
        
        return queue.poll();
        
        
    }
}