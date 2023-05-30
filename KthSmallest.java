//Time Complexity: O(m * n)
//Space Complexity: O(m * n)

import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
       PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

       int m = matrix.length;
       int n = matrix[0].length;

       for(int i = 0; i < m; i++) {
           for(int j = 0; j < n; j++) {
               q.add(matrix[i][j]);
           }
       }

       int index = q.size() - k;
       int l = 0;
       while(l < index) {
         q.poll();
         l++;
       }

       return q.peek();
    }
}