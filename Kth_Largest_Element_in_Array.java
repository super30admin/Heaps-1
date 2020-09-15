//BruteForce

//Sort the array in descending order nd return kth element
//Time: O(nlogn) + O(k) ==> O(nlogn)


//Approach2 - using Min Heap
//put k elemnts in min heap
//compare the root with other elemnt and at the end you will have kth largest lement in the root


//Time Complexity: O(nlogk) ==> iterating over n elements and putting just k elemnts in minHeap
//Space Complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length ==0 || k==0)
            return -1;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //put first k elements in priority queue
        for(int i=0; i<k; i++)
        {
            minHeap.add(nums[i]);
        }
        
        //now iterate over the array
        for(int i=k; i<nums.length; i++)
        {
            if(nums[i] > minHeap.peek())
            {
               minHeap.remove();
               minHeap.add(nums[i]);
            }
        }
        
        return minHeap.peek();
    }
}
