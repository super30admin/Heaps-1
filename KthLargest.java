// TC = nlog(k)
// SC = O(k)
// Here we are using Heap i.e priority queue(By default its min heap). 
// We will keep window of size k if size in greater than k then will poll elemtn.
// At the end we will poll element from heap. That means at end I will leaft with larget k bigger element in queue.

class KthLargest{
    
    public int findKthLargest(int[] nums, int k) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
}