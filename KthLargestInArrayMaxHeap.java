import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestInArrayMaxHeap {

        public int findKthLargest(int[] nums, int k) {

            // max heap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            int result = Integer.MAX_VALUE;

            int n = nums.length;

            for(int num: nums) {

                pq.add(num);

               // to avoid null pointer exception
               if(!pq.isEmpty()) {

                   // (n - k) size max heap PQ contains elements smaller than root
                   // these elements in Max heap are (n-k) smaller numbers leaving k larger elements outside the heap
                   if(pq.size() > n - k) {

                       //k largest elements are above (n-k) size max heap are removed
                       int p = pq.poll();
                       //to understand the order
                       System.out.println(p);

                       //kth largest element of nums is the smallest in remaining k larger elements
                       result = Math.min(p, result);
                   }

               }


            }
            // output kth largest element
            return result;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            int[] arr = new int[size];

            System.out.println("Enter the elements of the array:");

            for (int i = 0; i < size; i++) {
                System.out.print("Enter element at index " + i + ": ");
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter k: ");
            int k = scanner.nextInt();

            scanner.close();

            KthLargestInArrayMaxHeap obj = new KthLargestInArrayMaxHeap();

            int answer = obj.findKthLargest(arr, k);

            System.out.println("Kth largest number in given array is " + answer);

        }

}

/*
for the kth largest element in an array

TIME COMPLEXITY = O(nlog(n-k)) with max heap = O(nlogk) with min heap

SPACE COMPLEXITY = O(n-k) with max heap = O(k) with min heap
*/