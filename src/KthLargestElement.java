// Time Complexity:       O(n*long(k))
// Space Complexity:      O(k)
// where n is number of elements in given array
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        KthLargestElement obj = new KthLargestElement();
        System.out.println(obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);

        for(int num : nums) {
            pq.add(num);                                   // adding incoming element in heap every time
            if(pq.size() > k) {                            // if heap size > k
                pq.remove();                               // removing top from heap every time
            }
        }
        return pq.peek();




// ****************************** Another Approach ******************************
//        Queue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);
//
//        for(int num : nums) {
//            if(pq.size() == k) {                            // if heap size = k
//                if(num >= pq.peek()) {                      // and incoming element >= top of heap
//                    pq.remove();                            // then swapping element with top of heap
//                    pq.add(num);
//                }
//            }
//            else {                                          // else simply add element in heap
//                pq.add(num);
//            }
//        }
//        return pq.peek();
    }
}
