//put the array elements in a mn heap and as soon as heap size id grater then k, remove the min element. in the end top k elements will be remaining in the heap.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
              if(minHeap.size() > k){
                minHeap.remove();
            }
            System.out.println(minHeap);
            
        }
        return minHeap.remove();
        
    }
}
