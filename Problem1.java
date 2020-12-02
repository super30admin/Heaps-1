
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
// Time Complexity : O(Nlog N) --> sorting result array.
// Space Complexity :O(N) --> storing the array.
// Your code here along with comments explaining your approach:
// 1. Store each element in the matrix into an array.
// 2. Sort the array and return the required element from the array.
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length,count = 0;
        int[] result = new int[n*n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                result[count] = matrix[i][j];
                count++;
            }
        }
        Arrays.sort(result);
        return result[k-1];
    }
// Time Complexity : less than O(Nlog N) since most of the array will be sorted.
// Space Complexity :O(N) --> storing the array.
// Your code here along with comments explaining your approach:
// 1. First take first row and column elements and sort them and add them to the array.
// 2. Do this for all remaining rows and columns.
// 3. Now sort the array , since most of the array is sorted , it will be better than the previous approach.
     public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int[] result = new int[n*n];
        if(k==1 )
            return matrix[0][0];
        result[0] = matrix[0][0];
        int count = 0;
        for(int i = 0;i<n;i++){
            count = fillArray(result,matrix,i,count,n);
        }
        Arrays.sort(result);
        return result[k-1];
    }
    public int fillArray(int[] result,int[][] matrix,int i,int count,int n){
        result[count] = matrix[i][i];
        count++;
        int i1=i,j1=i+1,i2=i+1,j2=i;
        while(j1<n && i2<n){
            if(matrix[i1][j1]<matrix[i2][j2]){
                result[count] = matrix[i1][j1];
                j1++;
            }
            else{
                result[count] = matrix[i2][j2];
                i2++;
            }
            count++;
        }
        while(j1<n){
            result[count] = matrix[i1][j1];
            count++;
            j1++;
        }
        while(i2<n){
            result[count] = matrix[i2][j2];
            count++;
            i2++;
        }
        return count;
    }
}
