import java.util.PriorityQueue;

public class kLargest{
    // min heap approach - o(nlogk)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b); //by default it will be min heap, if we want different we need to add a comparator. 
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                //remove 
                pq.poll();
            }
        }
        return pq.peek();
    }

    //max heap approach -we are keeping the size as n-k 0(nlog(n-k))
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
    //     int result = Integer.MAX_VALUE;
    //     for(int i = 0; i < nums.length; i++){
    //         pq.add(nums[i]);
    //         if(pq.size() > nums.length - k){
    //             //remove 
    //             result = Math.min(result, pq.poll());
    //         }
        
    //     }
    //     return result;
    // }
}