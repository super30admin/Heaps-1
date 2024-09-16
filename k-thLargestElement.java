//time complexity: O(n log k)
//space complexity : O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> a - b);
        
        for(int n: nums)
        {
            if(pq.size() < k)
            {
                pq.offer(n);
            }
            else
            {
                if(pq.peek() < n)
                {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
        
    }
}