// Approach : Using Min Heap
// Time : O(nlogk)
// Space : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        // min heap default - (a,b) => (a-b) Asceneding order
        // max heap - (a,b) => (b-a) Descending order
        for(int i=0;i<nums.length;i++){
            if(pq.size() <k){
                pq.add(nums[i]);
            } else{
                if(pq.peek()<nums[i]){
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
            // heapify happens
        }
        return pq.peek();
    }
}

// Approach : Using Min Heap
// Time : O(nlogk)
// Space : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        // min heap default - (a,b) => (a-b) Asceneding order
        // max heap - (a,b) => (b-a) Descending order
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                // ensures heap of constant size k
                pq.poll(); // remove the extra element 
            }
            // heapify happens
        }
        return pq.peek();
    }
}

// Approach : Using Max Heap
// Time : O(nlogn-k)
// Space : O(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Integer[] arr = {2,5,1,4,3};
        // Arrays.sort(arr,(a,b)->{
        //     return b-a;
        // });
        // System.out.println(Arrays.toString(arr));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // max heap
        // min heap default - (a,b) => (a-b) Asceneding order
        // max heap - (a,b) => (b-a) Descending order
        int result = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>nums.length-k){
                result = Math.min(result,pq.poll());
            }
        }
        
        return result;
    }
}