//TC O(n log k) //n-> num of elements
//SC O(n) // heap space in worst case
//Executed in leet code : yes
import java.util.PriorityQueue;

//Use min heap to find the largest element.
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num: nums){
            pq.add(num);
            System.out.println(" pq element: "+pq.peek());
            if(pq.size() > n- k){
                result = Math.min(result, pq.poll());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{5,4,3,2,1};
        int res = KthLargestElement.findKthLargest(in, 2);
        System.out.println(res);
    }
}