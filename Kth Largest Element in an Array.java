/*
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap, num)
            
            if len(heap) > k:
                heapq.heappop(heap)
        
        return heapq.heappop(heap)
*/

// Time Complexity : O(nlogk)
// Space Complexity : O(k)

// Your code here along with comments explaining your approach: I maintained a min heap of size k 

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:nums){
            pq.add(num);
            
            if (pq.size() > k)
                pq.remove();
        }
        return pq.remove();
        
    }
}