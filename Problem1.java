import java.util.PriorityQueue;
/*
Kth Largest Element in an array
approach: use a min-heap(keep utmost k elements in heap) or max-heap (keep utmost n-k elements and min value,
when popped, compare with min element)
time: min heap: O(n log k) max-heap: O(n log (n-k))
space: min heap: O(k) max-heap: O(n-k)
 */
public class Problem1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q =  new PriorityQueue<>();

        for(int n: nums) {
            q.add(n);
            if(q.size()>k) {
                q.poll();

            }
        }
        return q.poll();
    }

    public int findKthLargestMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> q =  new PriorityQueue<>((a,b)->(b-a));
        int min = Integer.MAX_VALUE;
        for(int n: nums) {
            q.add(n);
            if(q.size()>(nums.length-k)) {
                min = Math.min(q.poll(), min);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
