// Time Complexity : O(nlogk) n is number of elements
// Space Complexity : O(k) k is the kth largest element
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer> q = new PriorityQueue<>();
        for(int num : nums){
            q.add(num);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String[] args){
        KthLargest k = new KthLargest();
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}