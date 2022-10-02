import java.util.PriorityQueue;

// Using MinHeap
// TC - O(n log k) where n is number length of nums array and k is the given kth value
// SC - O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums){
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}


// Using MaxHeap
// TC - O(n log (n-k))
// SC - O(n-k)
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a );
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int num : nums){
            pq.add(num);
            if (pq.size() > n-k) {
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
} //Array.sort((a,b)-> a-b)