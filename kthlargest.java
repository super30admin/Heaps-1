
//TC: NlogK, where N is the number of elements in the array, K is the K in "K"th largest element
//SC: O(K) K is the K in "K"th largest element.

//approach 1 using a min heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}

