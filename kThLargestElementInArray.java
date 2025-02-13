import java.util.PriorityQueue;

//215. Kth Largest Element in an Array
//TC: O(nlogk)
//SC: O(k)
class kThLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // Using min heap (in java priority queue acts as min heap)
        // for max heap it pq will be like this PriorityQueue<Integer> pq = new
        // PriorityQueue<> ((a,b)->b-a);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}