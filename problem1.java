class KLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.poll();
    }
}

//time complexity O(nlog k) n is length of nums
//space complexity O(k) 