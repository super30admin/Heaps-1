/*
Desc : Min Heap is used best in this case as we have to however iterate throughout the whole array, while space used by heap would be just k,
while max heap would use n-k space.
Time Complexity : min heap O(nlog(k)) , max heap O(nlog(n-k))
Space Complexity : O(k)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int result = Integer.MAX_VALUE;
        for(int num : nums){
            pq.add(num);
            if(pq.size()>(n-k)){
                result = Math.min(result,pq.poll());
            }
        }
        return result;
    }
}
/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int num : nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
