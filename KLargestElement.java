import java.util.PriorityQueue;

public class KLargestElement {
//TC=O(nlog(k))
//SC=O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> kElements=new PriorityQueue<>((a, b)->a-b);
        for(int num: nums){
            kElements.add(num);
            if(kElements.size()>k)
                kElements.poll();
        }
        return kElements.peek();
    }
}
