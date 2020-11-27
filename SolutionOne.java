// Time Complexity :O(n log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no

class SolutionOne {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();//min heap

        for(int num:nums)
        {
            pq.add(num);

            if(pq.size()>k)
            {
                System.out.println(pq.poll());
            }

        }

        return pq.peek();
    }
}