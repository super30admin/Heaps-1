//Time Complexity: O(nlogk)
//Space Complexity: O(k)
//Did it run on leetcode: yes
/** Approach: I use a minHeap and keep always the size=k
    so when I try to add an element and is size exceeds the top element is removed.
    This makes sure that in the end the kth largest element is at the top**/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i:nums){
            minHeap.add(i);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        
        return minHeap.poll();
    }

}
