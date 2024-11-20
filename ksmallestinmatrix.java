


o(n*mlog(n)) without priority queue


class Solution {
      public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];
        
          while(low <= high){
              
            int mid = low + (high - low) / 2;
            int count = 0;
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] <= mid){
                    count++;
                }
            }
        }
            if(count < k){
                low =  mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    
    }
    
    }
