//## Problem1 Kth largest in Array (https://leetcode.com/problems/kth-largest-element-in-an-array/)

//2 solutions

// max heap (less efficient)

// Time Complexity : O(Nlog (N-k)) 
// Space Complexity : O(N-k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// approach: iterate thru the array, keep adding an element at a time and if the size of heap gets greater than n-k start removing the root (largest element), keep a variable outside to track the minimum of the element taken out. This will be the number just bigger than the n-k smallest elements that the heap holds.

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            if(pq.size() > n-k)
            {
                min = Math.min(min,pq.poll());
            }
        }
        return min;
        
    }
}

// min heap (more efficient)

// Time Complexity : O(Nlog k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// approach: keep adding elements to a min heap. whenever the size exeeds k remove an element this will store the k largest elements, and the root of heap would with the kth element from the end


class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            pq.add(nums[i]);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.peek();
        
    }
}
