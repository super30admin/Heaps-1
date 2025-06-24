/*
 * TC: O(n*logk) n: size of nums[], k: size of Priority Queue.
 * SC: O(k) k: size of Priority Queue.Also, its the kth element to find.
 * 
 * Approach: Using min heap, i will create priority queue. keep adding the num from the nums[]. and each time the size of queue 
 * becomes more than k, i will pop the top element i.e the min. at the end i will have k elements in my queue. so , will return the top element.
 * 
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int num : nums){
            q.add(num);
            if(q.size() > k) q.poll();
        }

        return q.poll();
    }
}