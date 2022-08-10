// time n logn
//space 0(k)
/*class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums== null || nums.length==0)
        {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n =nums.length;
        int result=Integer.MAX_VALUE;
        int temp=0;
        if(nums== null || nums.length==0)
        {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size()>n-k)
            {
                temp= pq.poll();
                result= Math.min(result,temp);
            }
        }
        return result;
    }
}