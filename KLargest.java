// Time Complexity :O(N log(k)) N = no of nodes in heap and K = no of lementd to heapify
// Space Complexity : O(K)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Use Min Heap and Heapify until you have k elements. If the no of elements if greater than k then remove the top
// element in the heap.

import java.util.*;

class KLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int num : nums) {
            p.add(num);

            if (p.size() > k) {
                p.remove();
            }
        }
        return p.remove();
    }

    public static void main(String args[]) {
        KLargest obj = new KLargest();
        // 1 2 3 4 5 6
        int nums[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k));
    }

}