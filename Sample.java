//****Kth LARGEST ELEMENT IN ARRAY USING MIN HEAP****
//KEEP SIZE OF HEAP AS K;
//Time complexity:nlogk where n is the size of array and k is the size of heap
//Space complexity:0(k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            //If size exceeds perform pop;
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

//****Kth LARGEST ELEMENT IN ARRAY USING MAX HEAP****
//KEEP SIZE OF HEAP AS N-K;
//Time complexity:nlog(n-k) where n is the size of array and k is the size of heap
//Space complexity:0(n-k);
//Leetcode runnable: Y;
//Any doubts: No;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=nums.length;
        int result=Integer.MAX_VALUE;
        //Iterate through array and add elements to heap
        for(int num:nums)
        {
            pq.add(num);
            
            if(pq.size()>n-k)
            {
                result=Math.min(result,pq.poll());
            }
        }
        return result;
    }
}
