package s30.heaps;

import java.util.PriorityQueue;
//Algo: add elements to max heap and  kth element to remove is the answer.

// TC: nlogk
// SC: O(n)
public class kthLargestElement {

    PriorityQueue<Integer> pq ;
    public int findKthLargest(int[] nums, int k) {

        pq = new PriorityQueue<>((a,b) -> b-a);

        for(int n : nums){
            pq.add(n);
        }

        while(k > 1){
            pq.remove();
            k--;
        }

        return pq.remove();

    }
    public static void main(String[] args) {

    }
}
