class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int res=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums)
        {
            pq.add(num); //logk
            if(pq.size()>k)
            {
                //removing the minimum element
                pq.poll(); //logk
            }
        }
        return pq.peek();
        
    }
}

//tc: logk + log k 
//sc: O(k)
//using heap beacuse we can fix the size of the heap and do not need all the elements inside the heap
