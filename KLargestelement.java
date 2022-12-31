//Time Complexity: O(nlogk) // n is the size of nums and k is the number of elements in queue.
//Space Complexity: O(k)

//maintain a min heap
/*
 * maintain a nim heap of size k and if the size increses pop hte last element.
 * the idea is that we only keep the k greatest values in the queue and remove
 * the rest.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num: nums){
            q.add(num);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }
}

//maintain a max heap
/*
 * maintain a nim heap of size k and if the size increses pop hte last element.
 * the idea is that we only keep the k lowest values in the queue and remove the 
 * minimum of the next value inserted and the top.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for(int num: nums){
            q.add(num);
            if(q.size() > n-k){
                result = Math.min(result, q.poll());
            }
        }
        return result;
    }
}