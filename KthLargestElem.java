import java.util.PriorityQueue;
//leetcode - 215
public class KthLargestElem {
    public int findKthLargest(int[] nums, int k) {

        //Using MinQueue Nlog(K)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    //Using MaxHeap //Nlog(N-K)
    /*public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);//Max Heap
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > n-k) {
                result = Math.min(result, pq.poll());
            }
        }
        return result;
    }*/
}
