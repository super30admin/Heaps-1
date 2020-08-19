//Time Complexity : O(nlogk)
//space complexity : O(1)
import java.util.PriorityQueue;

public class KthLargestInArray{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i = 0; i < nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static void main(String args[]){
        KthLargestInArray obj = new KthLargestInArray();
        System.out.println(obj.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}