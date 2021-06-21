//Min heap approach
//Time Complexity : O(n*logk).logk time to insert k elememts into heap and this is done n times
//Space Complexity : O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return -1;
        }
        //using priorty queue to implement min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            //build the heap of size k
            pq.add(n);
            //when the size is surpassing k, delete the element.i.e min elemnet at the top of the heap
            if(pq.size() > k){
                pq.poll();
            }
        }
        //In the end, the root will have the kth largest element
        return pq.peek();
    }
}
//MAX heap approach
//Time Complexity : O(n * log(n-k)). log(n-k) time to insert n-k elememts into heap and this is done n times
//Space Complexity : O(n-k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return -1;
        }
        //using priorty queue to implement max heap
        //to use the queue as max heap include the comparator (a,b)->b-a
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            //build the heap of size nums.length-k
            pq.add(n);
            //when the size is surpassing n-k, delete the element.i.e max elemnet at the top of the heap and store the min
            if(pq.size() > nums.length-k){
                min = Math.min(min,pq.poll());
            }
        }
        return min;
    }
}
//MAX heap approach
//Time Complexity : O(n * log(n-k+1)). log(n-k+1) time to insert n-k elememts into heap and this is done n times
//Space Complexity : O(n-k+1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return -1;
        }
        //using priorty queue to implement max heap
        //to use the queue as max heap include the comparator (a,b)->b-a
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            //build the heap of size nums.length-k
            pq.add(n);
            //when the size is surpassing n-k, delete the element.i.e max elemnet at the top of the heap 
            if(pq.size() > nums.length-k+1){
               pq.poll();
            }
        }
        return pq.peek();
    }
}