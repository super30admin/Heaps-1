//TC: O(NlogN)
//SC : O(1)

// simple solution
class Solution {
                public static int findKthLargest(int[] nums, int k)
        { 
	        Arrays.sort(nums);

	        int h = nums[nums.length-k];

	        return h;
        }
}

// solution 2 using priority queue
//TC: O(NlogK)
//SC : O(K)
 public int findKthLargest_pq(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
