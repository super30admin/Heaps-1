import java.util.PriorityQueue;
import java.util.Scanner;


public class KthLargestInArrayMinHeap {

        public int findKthLargest(int[] nums, int k) {

            // min heap = default
            // PriorityQueue<>((a, b) -> a - b)
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

            for(int num: nums) {

                pq.add(num);

                if(!pq.isEmpty()) {

                    if(pq.size() > k) {

                        //minimum numbers are maintained above k size and removed
                        int i = pq.poll();
                        System.out.println(i);
                    }
                }
            }
            // k numbers remaining in pq are k largest, the minimum at the top/ front of pq = kth largest is given as output
            if(!pq.isEmpty()) {

                // to avoid null pointer exception
                return pq.poll();
            }
            return -1;
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

        KthLargestInArrayMinHeap obj = new KthLargestInArrayMinHeap();

        int answer = obj.findKthLargest(arr, k);

        System.out.println("Kth largest number in given array is " + answer);

    }

}
