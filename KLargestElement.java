class Solution {
    public int findKthLargest(int[] nums, int k) {

        int result = Integer.MIN_VALUE;

     //  result = usingMaxHeap(nums,k);
       result = usingMinHeap(nums,k); 
        
        return result;
    }

    private int usingMinHeap(int[] nums, int k){

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int num : nums){
            maxHeap.add(num);
            if(maxHeap.size()>k){
              maxHeap.poll();
            }
        }
        return maxHeap.peek();

    }

    private int usingMaxHeap(int[] nums, int k){
        int heapSize = nums.length-k;
        System.out.println(heapSize);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
         int result = Integer.MAX_VALUE;
        for(int num : nums){
            maxHeap.add(num);
            if(maxHeap.size()>heapSize){
              result = Math.min(maxHeap.poll(), result);
            }
        }
    
        return result;
    }
}