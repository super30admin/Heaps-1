//Time complexity:O(nlogk)
//space complexity:O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new  PriorityQueue<>((a,b)-> b-a);//max
        int n=nums.length;
        int max=Integer.MAX_VALUE;
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size()>n-k)
            {
                max=Math.min(pq.poll(),max);
            }
        }
        return max;
    }
}
