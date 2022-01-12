// Time Complexity: O(nlogk) heaping log k times for n elements
// Space Complexity: O(k)
// if making min heap of size n elements Time Complexity O(nlogn) + O(klogn) (build heap + remove min k times and heapify)
// min heap
public class KLargestElementArray {
    public int findKthLargest(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue(); // default min heap
        
        for(int n : nums)
        {
            pq.add(n);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}

// Time Complexity: O(nlog(n-k+1))
// Space Complexity: O(n-k)
// max heap
public class KLargestElementArray {
    public int findKthLargest(int[] nums, int k)
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); 
    
        for(int n : nums)
        {
            pq.add(n);
            if(pq.size() > (nums.length-k+1))
            {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
