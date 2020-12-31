/** Find the kth largest element in an unsorted array. Note that it is the kth largest element 
* in the sorted order, not the kth distinct element.
* TC O(Nlogk) SC O(k). Maximum elements in the heap is k
*/
class Solution {
    PriorityQueue<Integer> q;
    public int findKthLargest(int[] nums, int k) {
        q = new PriorityQueue<Integer>();
        if (nums == null || nums.length == 0)
            return 0;
    
        int i = 0;
        while (i < nums.length) {
            q.add(nums[i++]);
            if (i > k){
                q.remove();
            }
        }
        return q.remove();
    }
}
