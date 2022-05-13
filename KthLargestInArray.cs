// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Whenever we inset new element we check min heap condition and number of elements shoulebe less than k. 
// we remove from hea top element
public int FindKthLargest(int[] nums, int k) {
        if(nums == null || nums.Length == 0)
            return 0;
        
        PriorityQueue<int, int> queue = new PriorityQueue<int, int>();
        
        foreach(var num in nums)
        {
            queue.Enqueue(num, num);
            if(queue.Count > k)
                queue.Dequeue();
        }
        
        return queue.Dequeue();
    }

