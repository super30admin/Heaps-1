// Time Complexity : O(n log k) -> inserting into heap take logrithmic time, since we are performing this operation n times, TC is n log k.
// Space Complexity : O(k) -> size of heap will be K
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
    //None

class kLargestElementInArray{
    public Integer findKLargest(int[] nums, int k){

        //Idea is to Push elements into the heap of size k
        //if the number of elements in the heap is greater than k then pop the element
        //continue until we have reached end of the list nums
        //the k Largest element would be the first element of heap, return that.

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        } 

        return pq.peek();

    }
}