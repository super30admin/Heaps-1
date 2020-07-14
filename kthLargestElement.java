// 215.
//approach - have a heap of size k, and ensure that heap always has k largest elements in the array, at end return top
//time - O(nlogk)
//space - O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        PriorityQueue<Integer> support = new PriorityQueue<>(); //by default a min heap
        for(int num : nums)
        {
            if(support.size() < k)
            {
                support.offer(num); //continue adding to heap as long as size of heap is less than k
            }
            else //size of heap is k here
            {
                if(num > support.peek())
                {
                    //if size is k, if num is less than root of heap, then ignore else poll from heap and add num
                    support.poll(); 
                    support.offer(num);
                }
            }
        }
        
        return support.peek(); //kth largest in nums[]
    }
}
