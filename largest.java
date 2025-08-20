//Time Complexity :O(n log k) - Adding to heap takes O(log k), and we do it n times.
//Space Complexity :O(k) - The heap stores at most k elements.

//Use a min-heap (PriorityQueue) to maintain the k largest elements seen so far.
//Traverse the array, adding each element to the heap; if size exceeds k, remove the smallest.
//After processing all elements, the heap root (poll) gives the k-th largest element.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++)
        {
            pq.add(nums[i]);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}