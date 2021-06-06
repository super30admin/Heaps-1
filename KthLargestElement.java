import java.util.*;

public class KthLargestElement {


    //TC: O(N Log(K)) - maximum k elements will be in the priority queue.
    //SC:O(K) for the pririty queue
    public int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) { //N
            pq.add(nums[i]);//LogK
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    //TC: O(N Log(N-K)) - maximum n-k elements will be in the priority queue.
    //SC:O(N-K) Maximum N-K elements will be in the priority queue.
    public int findKthLargestMaxHeap(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) { //N
            pq.add(nums[i]); //N-K
            
            if (pq.size() > nums.length - k) {
                result = Integer.min(result,pq.poll());
            }
        }
        return result;
    }

    public int findKthLargestMaxHeapPractise(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) -> (a-b)); 
        for(int i=0;i<array.length;i++) {
            queue.add(array[i]);
            if(queue.size() >k) {
               queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int k = 2;
        int largestElement = kthLargestElement.findKthLargestMaxHeapPractise(new int[] { 3, 2, 1, 5, 6, 4 }, k);
        System.out.println("The " + k + "th Largest element is" + largestElement);
    }
}