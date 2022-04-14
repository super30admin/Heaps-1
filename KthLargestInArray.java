//Time Complexity : O(nlogk) n = length of nums
//Space Complexity : O(n)

class Solution {

    //using min heap

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int e : nums)
        {
            pq.add(e);
            //keep adding till size = k, then remove the min
            if(pq.size() > k)
                pq.poll();
        }

        //now only k largest elements left in heap, return the min in them
        return pq.poll();
    }
}
