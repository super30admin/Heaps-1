//Timecomplexity:- O(nlogk) n for iterating and log k for heapsize k.
//Spacecomplexity:-O(k) for heap size.
//Did it run on leetcode:- Yes.
//What problem did you face?:- got lot of more time taking solutions.
//your approach with code:- constructing heap of min size k iteratively in given array and removing extra element by root.
//like this you will get upto n-k elements and in last k elements getting root element.



class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minheap.add(nums[i]);
            if(minheap.size()>k){ // if sizeis greater than k swapping root with last leaf and heapification is done 
                                  // internally.
                minheap.remove();
            }
        }
    return minheap.peek();}
}