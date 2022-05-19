import java.util.PriorityQueue;

/**
 * Time complexity : O(n log n-k)
 * Space complexity : O(n-k)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestEleInArrayUsingMaxHeap {
    public static void main(String[] args) {
        int kMin = findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(kMin);
    }
    private static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        /*PriorityQueue in Java is min heap
        * so we defined a comparator for max heap*/
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        /*We add all input elements into max heap one by one*/
        for(Integer n : nums){
            priorityQueue.add(n);
            /*After adding every element to heap, we check
             * if heap size is greater than (nums.length - k), if yes then we poll the max from heap
             * and we store min of result and polled value in result
             * At any point the size of heap is (nums.length - k) and kth min is maintained
             * in the result */
            if(priorityQueue.size() > (nums.length - k)){
                result = Math.min(result, priorityQueue.poll());
            }
        }
        return result;
    }
}
