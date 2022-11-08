//approach - 1 min-heap based solution
//min-heap based solution
//TC -O(n log k) -> log(k) to do min heap for 1 node, and for n nodes nlog(n)!
//sc -O(k) for array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length ==0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = Integer.MAX_VALUE;
        
        //min heap based solution
        for(int num: nums)
        {
            pq.add(num);
            // System.out.println("added -"+num);
            // System.out.println("result -"+result);
            
            if(pq.size() > k)
            {     
                pq.poll();
                // System.out.println("change result -"+result);
           }
            // System.out.println("");
        }
        return pq.poll();
    }
}

//approach -2 max-heap based solution
//TC -O(n log n-k) -> log(n-k) to do min heap for 1 node, and for n nodes nlog(n-k)!
//sc -O(n-k) for array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length ==0) return -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int result = Integer.MAX_VALUE;
        
        //max heap based solution
        for(int num: nums)
        {
            pq.add(num);
            // System.out.println("added -"+num);
            // System.out.println("result -"+result);
            
            if(pq.size() > nums.length - k)
           {     result = Math.min(result, pq.poll());
            // System.out.println("change result -"+result);
           }
            // System.out.println("");
        }
        return result;
    }
}