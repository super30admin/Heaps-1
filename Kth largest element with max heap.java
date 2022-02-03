//Time complexity: O(nlogk)
//Space complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>((a,b)->b-a);
        for(int i: nums)
        {
            maxheap.add(i);
            if(maxheap.size()>(nums.length-k+1))
            {
                maxheap.remove();
            }
        }
        
        return maxheap.peek();
        
    }
}