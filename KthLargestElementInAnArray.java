import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    //Time complexity = O(nlogK)
    //space complexity = O(logk)
    class SolutionUsingMinHeap {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            //Using Min heap approach storing size of k
            for(int i=0; i<nums.length; i++){
                pq.add(nums[i]);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }

    //Time complexity = O(nlogn-K)
    //space complexity = O(logk)
    class SolutionUsingMaxHeap {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
            int result = Integer.MAX_VALUE;
            //Using Max heap approach storing size of n-k
            for(int i=0; i<nums.length; i++){
                pq.add(nums[i]);
                if(pq.size()> nums.length-k){
                    result = Math.min(pq.poll(), result);
                }
            }
            return result;
        }
    }
}
