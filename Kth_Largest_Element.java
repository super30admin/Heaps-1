//TimeComplexity-O(nlogk)
//Space Complexity-O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>priorityQueue=new PriorityQueue();
        for(int num:nums)
        {
            priorityQueue.add(num);
            if(priorityQueue.size()>k)
            {
                priorityQueue.remove();
            }
        }
        return priorityQueue.remove();
    }
}