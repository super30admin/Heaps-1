// Time Complexity : O(n logk) + O(n logk) for insertion and deletion of elements from heap
// Space Complexity : O(k)  (the heap size is fixed to k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

/* approach 1
we can do maxheap to store all the elements at once then do pop for k times to get the k largest element

but time complexity is O(k logn ) + o(n logn) for deletion and insertion respectively
so, it is not better than sorting in the worst case
*/
/* approach 2
Here  we add the numbers to the minheap instead of maxheap

if the size is more than k, poll the min out

(we are using minheap since we know the min from minheap of size k is useless)

so here we only keep the k largest element 
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}