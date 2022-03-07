import java.util.PriorityQueue;
/*
Time Complexity: O(Nlogk) N is the number of elements in the nums array
Space Complexity: O(k), k is the size of priority queue
Run on leetcode: yes

Approach:
1. Priority queue maintains elements in it in ascending order
2. To find out K-th largest element I would just need to iterate towards
 */
public class KthLargestElementInAnArray {
    public static int kthLargestElement(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        System.out.println("Kth Largest Element: "+kthLargestElement(nums, 2));
    }
}
