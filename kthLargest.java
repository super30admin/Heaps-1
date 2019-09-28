//brute force
//Time Complexity:O(NlogN)
//Space Complexity:O(1)
//Here I'll simply be sorting the array and return the kth largest element from the end.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
}
//Heaps
//Time Complexity:O(N)
//Space Complexity:O(N)
//Here, I'll be adding the array elements to a priority queue and then remove the elements from the queue as and when my minHeap size exceeds the given k. At the end I'll just be returning the root element which will be the kth largest element.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
