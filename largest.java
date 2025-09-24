class Solution {
    public int findKthLargest(int[] nums, int k) {
        //MIN HEAP
       /* PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        if(pq.size()>k){
            pq.poll();
        }
        }
        return pq.peek();*/
        //MAX HEAP
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();


    }
}