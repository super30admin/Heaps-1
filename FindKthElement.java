/**Leetcode Question 215 - Find kth Largest Element in an array */
/**Algorithms- Min Heap
 * Maintain a min heap of size k. Pop elements whenever the min heap size exceeeds k
 * The final heap will have the kth element as the root.
 */
/**TC - O(N) - the insertion complexity is usually O(NlogN) but when the elements are given in a single go, the upper bound for insertion can be tightened down to O(N)
 * SC - O(k) - The height of the tree
 */
public class FindKthElement {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return -1;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int num: nums){
                pq.add(num);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }
}
/**Algorithm - Max Heap - n-k +1 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num: nums){
            pq.add(num);
            if(pq.size()>nums.length - k + 1){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**Algorithm - Max Heap n- k */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num: nums){
            pq.add(num);
            if(pq.size()>nums.length - k){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}