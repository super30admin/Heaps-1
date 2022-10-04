class Solution {
    //min heap
    //tc- o(nlogk) where is k is kth largest element
    //sc- o(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);//acending order comparator
        for(int num : nums)
        {
            pq.add(num);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();

    }
}