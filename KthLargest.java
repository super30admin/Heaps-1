/* Approach 1:  Brute Force */
// Time Complexity : O(NlogN)
// Space Complexity : O(N)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];      
    }
}

/* Approach 2: Making a MinHeap of k elements */
// Time Complexity : O(NlogK)
// Space Complexity : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

/* Approach 3: Making a MaxHeap of n-k elements */
// Time Complexity : O(Nlog(N-k))
// Space Complexity : O(N-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            pq.add(num);
            if(pq.size() > n-k) {
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}

