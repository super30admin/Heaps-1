/*

TC: Heapify + Removal = O(N * logK) + O((N - K)* logK) where N - num of elements in array, K - kth largest
SC: O(K) size of heap

1. We construct a min heap and keep adding elements from array. 
2. Whenever the heap size exceeds k, the minimum element is removed.
3. After (N - K) transactions, the root of heap will have kth largest element. 


*/
import java.util.PriorityQueue;

public class KLargestElement{

    public static int kthLargest(int[] arr, int k){

        if(k < 1 || k > arr.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : arr){
            pq.add(num);
            if(pq.size() > k)
                pq.remove();
        }

        return pq.remove();
    }

    public static void main(String[] args){
        int[] arr = {3,2,3,1,2,4,5,6};
        System.out.println(kthLargest(arr, 0));
    }

}