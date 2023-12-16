//kth largest element in an array
//TC: nlog(k)
class Solution1 {
    public int findKthLargest(int[] nums, int k) {

        //min priority Queue with natural ordering
        //head of queue returns smallest element
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);//log(k)
            if(pq.size()>k)
            {
                pq.poll();// wed dont need k+1 th largest element
                //log(k)
            }
        }
        return pq.poll(); //smallest from head is kth largest element
        
    }
}