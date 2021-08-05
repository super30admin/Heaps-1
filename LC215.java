class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            heap.add(nums[i]);
            //System.out.println(heap);
            while(heap.size() > k){
                heap.poll();
            }
        }
        int ans = heap.poll();
        return ans;
    }
}

//Time : O(nlogk)
//Space : O(k)