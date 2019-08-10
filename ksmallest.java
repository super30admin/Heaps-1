class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      if(matrix==null || matrix.length==0)
          return -1;
        else{
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    pq.offer(matrix[i][j]);
                }
            }
            
            while(k>1)
            {
                pq.poll();
                k--;
            }
            return pq.poll();
        }
    }
}
