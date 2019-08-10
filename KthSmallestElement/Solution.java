/**
 * Time Complexity: O(k log(n))
 * Space Complexity: O(n) - heap storage
 * Leetcode : Yes
 * Idea:
 * 1. Push all elements into heap
 * 2. Poll k times
 */

import java.util.*;

class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                heap.add(matrix[i][j]);
            }
        }

        while(k>1){
            heap.poll();
            k--;
        }
        return heap.poll();
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Kth Smallest Element");
        KthSmallestElement obj = new KthSmallestElement();
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        int k = 8;

        System.out.println(obj.kthSmallest(matrix, k));
    }
}