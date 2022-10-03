/*
Time Complexity: O(n logn)
Space Complexity: O(k)
*/
class Solution {

public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int j = 0; j < nums.length; j++) {
                priorityQueue.add(nums[j]);
                if(priorityQueue.size()>k)
                    priorityQueue.poll();

        }
        return priorityQueue.poll();
}
}