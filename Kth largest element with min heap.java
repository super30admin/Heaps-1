//Time complexity: O(nlogk)
//Space complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>();
        for(int i: nums)
        {
            maxheap.add(i);
            if(maxheap.size()>k)
            {
                maxheap.remove();
            }
        }
        
        return maxheap.peek();
        
    }
}