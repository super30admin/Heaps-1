import java.util.PriorityQueue;

public class KlargestElement {

    /*
     PriorityQueue used for maxHeap or minheap using a comparator in the constructor
     timeComplexity nlogK and space complexity O(k)
    * */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a, b)->a-b);
        for(int num:nums){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
