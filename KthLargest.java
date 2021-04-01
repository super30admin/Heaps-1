//TC: O(nlogk + logk for remove)
//SC: O(k)
//Executed on leetcode
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new compq());
        int i = 1;
        for(int num:nums)
        {    
            minHeap.add(num);
            if(minHeap.size()>k)
                minHeap.remove();	//Adding each element to the minHeap and removing if size more than k.
									//So only K elements will be in minHeap, as on removing minHeap will remove minimum value.
        }							//So, min Heap will have K large elements of the list and Kth element will be on root.
									//We can just poll the value.
        return minHeap.poll();
    }
    
    class compq implements Comparator<Integer>
    {
        public int compare(Integer i,Integer j)
        {
            if(i<j)
                return -1;
            else if(i>j)
                return 1;
            else
                return 0;
        }
        /*Arrays.sort(nums);
        return nums[nums.length-k];*/
    }
}