//TC - O(klog(n))
//SC - O(n)

class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i = 0; i < nums.length; ++i)
        {
            pq.add(nums[i]);  
        }
        
        for(int i = 0; i < k - 1; ++i)
            pq.poll();
        
        return pq.poll();
        
    }
}

//TC - O(nlog(k)
//SC - O(k)

class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        for(int i = 0; i < nums.length; ++i)
        {
            pq.add(nums[i]);
            
            if(pq.size() > k)
                pq.poll();   
        }
        
        return pq.poll();
        
    }
}
