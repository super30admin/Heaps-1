import java.util.PriorityQueue;

/**
 * Time complexity : O(n log k)
 * Space complexity : O(k)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestEleInArrayUsingMinHeap {
    public static void main(String[] args) {
        int kMin = findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kMin);
    }

    private static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        /*PriorityQueue in Java is min heap*/
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(Integer n : nums){
            /*We add all input elements into min heap one by one*/
            priorityQueue.add(n);
            /*After adding every element to heap, we check
            * if heap size is greater than k, if yes then we poll the min from heap
            * At any point the size of heap is k and kth min is maintained
            * at the top of the heap */
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
