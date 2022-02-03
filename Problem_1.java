import java.util.PriorityQueue;

class Problem_1{
    public int findKthLargest(int[]nums,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int n:nums){
            pq.add(n);
            if(pq.size()>nums.length-k){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}