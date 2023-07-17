// Time Complexity= O(nlogk)
//Space complexity=O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i:nums){
            minHeap.add(i);

            if(minHeap.size()>k){

            
                minHeap.remove(); 
                }  //remove whatever is at root
        }
        return minHeap.remove(); // returns the kth largest elemnt

        



    }
}