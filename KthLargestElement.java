// Time Complexity :  O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
Approach:
1. Traverse the array and store its elements in min heap
2. If the size of heap exceeds k, pop the top heap element
3. At last, only k elements will be there in heap, out of which the kth largest elem would be on top
4. Pop the top heap element to get the result.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int n:nums){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }

        return pq.peek();
    }
}