/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

// T: O(log N)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while(left < right){
            
            int mid = left + (right - left) / 2;
            
            int num = getElements(matrix, mid);
            
            if(num < k)     left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    public int getElements(int[][] matrix, int mid){
        
        int count = 0;
        int j = matrix.length - 1;
        
        for(int i = 0; i < matrix.length; i++){
            
            while(j >= 0 && matrix[i][j] > mid) j--;
            
            count += j + 1;
        }
        
        return count;
    }
}