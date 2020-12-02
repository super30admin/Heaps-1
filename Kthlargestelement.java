//Time COmplexity: O(nlogk)
//space complexity : O(k)
//Tried and accepted on leetcode
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Intialise a minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        //iterate over the nums array
        for(int i:nums)
        {
            //throw the values into the heap
            minHeap.add(i);
            //CHeck of the size of the heap has exceeded k
            if(minHeap.size()>k)
            {
                //If so remove it out of the heap
                minHeap.remove();
            }
        }
        //Here only k elements will be presesnt in the heap 
        //since it is a min heap the below step will give us the kth largest element
        return minHeap.remove();
    }
}