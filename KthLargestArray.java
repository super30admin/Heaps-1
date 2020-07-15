// Brute Force
// Time Complexity - O(nlogn) 
// Space Complexity - O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}


// Using Min Heap
// Time Complexity - O(nlogk)
// Space Complexity - O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            pq.add(nums[i]);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}


// Using Max Heap
// Time Complexity - O(nlog(n-k))
// Space Complexity - O(n-k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            pq.add(nums[i]);
            if(pq.size() > nums.length-k) min = Math.min(min,pq.poll());
        }
        return min;
    }
}